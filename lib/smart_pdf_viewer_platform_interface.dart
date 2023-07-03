import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'smart_pdf_viewer_method_channel.dart';

abstract class SmartPdfViewerPlatform extends PlatformInterface {
  /// Constructs a SmartPdfViewerPlatform.
  SmartPdfViewerPlatform() : super(token: _token);

  static final Object _token = Object();

  static SmartPdfViewerPlatform _instance = MethodChannelSmartPdfViewer();

  /// The default instance of [SmartPdfViewerPlatform] to use.
  ///
  /// Defaults to [MethodChannelSmartPdfViewer].
  static SmartPdfViewerPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [SmartPdfViewerPlatform] when
  /// they register themselves.
  static set instance(SmartPdfViewerPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> getPlatformVersion() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }
}
