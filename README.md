# smart_pdf_viewer

A new Flutter plugin project.

## Dev steps

1. Import the Android_pdf_viewer module
2. Add the above module to build.gradle (:smart_pdf_viewer).
```
dependencies {
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation project(":android-pdf-viewer")
}
```
3. Add PdfViwerActivity.java
4. Create a new `res` folder. and add PdfViewerActiviy layout file for it.
---------------------------------------------------------------------------

5. Setup SmartPdfViewerPlugin.java
6. create assets folder and copy paste sample.pdf
7. Add PdfViewerActiviy activity to example's AndroidManifiest.xml
```
<activity
  android:name="com.degits.smart_pdf_viewer.PDFViewActivity"
  android:screenOrientation="portrait"
  android:theme="@style/Theme.AppCompat.Light.NoActionBar"/>
```

8. Run and see the pdf

---------------------------------------------------------------------------
# TODO
Implement method channel for open PdfViewerActivity (current imp will open PdfViewActivity on default method channel call)
