import 'package:flutter_test/flutter_test.dart';
import 'package:smart_pdf_viewer/smart_pdf_viewer.dart';
import 'package:smart_pdf_viewer/smart_pdf_viewer_platform_interface.dart';
import 'package:smart_pdf_viewer/smart_pdf_viewer_method_channel.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockSmartPdfViewerPlatform
    with MockPlatformInterfaceMixin
    implements SmartPdfViewerPlatform {

  @override
  Future<String?> getPlatformVersion() => Future.value('42');
}

void main() {
  final SmartPdfViewerPlatform initialPlatform = SmartPdfViewerPlatform.instance;

  test('$MethodChannelSmartPdfViewer is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelSmartPdfViewer>());
  });

  test('getPlatformVersion', () async {
    SmartPdfViewer smartPdfViewerPlugin = SmartPdfViewer();
    MockSmartPdfViewerPlatform fakePlatform = MockSmartPdfViewerPlatform();
    SmartPdfViewerPlatform.instance = fakePlatform;

    expect(await smartPdfViewerPlugin.getPlatformVersion(), '42');
  });
}
