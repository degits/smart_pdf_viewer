package com.github.barteksc.pdfviewer


import android.os.Handler
import android.os.Looper
import com.github.barteksc.pdfviewer.source.DocumentSource
import com.shockwave.pdfium.PdfiumCore
import com.shockwave.pdfium.util.Size
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


class DecodingTask(
    private val docSource: DocumentSource,
    private val password: String? = null,
    private val userPages: IntArray? = null,
    private var pdfView: PDFView,
    private val pdfiumCore: PdfiumCore,
) {

    //! visit:  https://developer.android.com/guide/background/asynchronous/java-threads#use-handlers
    private val executorService: ExecutorService = Executors.newFixedThreadPool(1)
    private val mainThreadHandler: Handler = Handler(Looper.getMainLooper())

    //
    //var executorService: ExecutorService? = Executors.newFixedThreadPool(4)
    //var mainThreadHandler: Handler = Handler(Looper.getMainLooper())


    private lateinit var pdfFile: PdfFile

    private fun getViewSize(pdfView: PDFView): Size {
        return Size(pdfView.width, pdfView.height)
    }

    fun execute() {
        /*try {
            Thread { run() }.start()
        */
        try {
            //! visit:  https://developer.android.com/guide/background/asynchronous/java-threads#use-handlers
            executorService.execute {
                mainThreadHandler.post {
                    val pdfDocument =
                        docSource.createDocument(pdfView.context, pdfiumCore, password)
                    pdfFile = PdfFile(
                        pdfiumCore,
                        pdfDocument,
                        pdfView.getPageFitPolicy(),
                        getViewSize(pdfView),
                        userPages,
                        pdfView.isSwipeVertical(),
                        pdfView.getSpacingPx(),
                        pdfView.isAutoSpacingEnabled(),
                        pdfView.isFitEachPage()
                    )
                    pdfView.loadComplete(pdfFile)
                }
            }
        } catch (t: Throwable) {
            pdfView.loadError(t)
        }

    }

    /**
     * Call to cancel background work
     */
    fun cancel() {
        executorService.shutdown()
        mainThreadHandler.removeCallbacksAndMessages(null)
    }

    /*fun run(): Unit {
        val pdfDocument = docSource.createDocument(pdfView.context, pdfiumCore, password)
        pdfFile = PdfFile(
            pdfiumCore,
            pdfDocument,
            pdfView.getPageFitPolicy(),
            getViewSize(pdfView),
            userPages,
            pdfView.isSwipeVertical(),
            pdfView.getSpacingPx(),
            pdfView.isAutoSpacingEnabled(),
            pdfView.isFitEachPage()
        )
    }*/
}