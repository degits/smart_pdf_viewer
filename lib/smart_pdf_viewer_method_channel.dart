import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'smart_pdf_viewer_platform_interface.dart';

/// An implementation of [SmartPdfViewerPlatform] that uses method channels.
class MethodChannelSmartPdfViewer extends SmartPdfViewerPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('smart_pdf_viewer');

  @override
  Future<String?> getPlatformVersion() async {
    final version = await methodChannel.invokeMethod<String>('getPlatformVersion');
    return version;
  }
}
