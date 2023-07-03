
import 'smart_pdf_viewer_platform_interface.dart';

class SmartPdfViewer {
  Future<String?> getPlatformVersion() {
    return SmartPdfViewerPlatform.instance.getPlatformVersion();
  }
}
