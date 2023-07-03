package com.degits.smart_pdf_viewer;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.github.barteksc.pdfviewer.util.FitPolicy;

public class PDFViewActivity extends AppCompatActivity {

    PDFView pdfView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void setContentView(int layoutResID) {   //   R.layout.activity_main = int layoutResID
        //   Layer - 01
        super.setContentView(layoutResID);

        this.pdfView = findViewById(R.id.pdfView);


        //   Layer - 02
        pdfView.setBackgroundColor(Color.LTGRAY);


        //   Layer - 03
        pdfView.fromAsset("sample.pdf")
                //.defaultPage(1)
                //.onPageChange(this)
                .enableAnnotationRendering(true)
                //.onLoad(this)
                .scrollHandle(new DefaultScrollHandle(this))
                .spacing(6) // in dp
                //.onPageError(this)
                .pageFitPolicy(FitPolicy.WIDTH)
                .load();
    }
}