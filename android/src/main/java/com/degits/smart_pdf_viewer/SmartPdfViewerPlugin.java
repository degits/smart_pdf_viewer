package com.degits.smart_pdf_viewer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

/** SmartPdfViewerPlugin */
public class SmartPdfViewerPlugin implements FlutterPlugin, MethodCallHandler, ActivityAware {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private MethodChannel channel;

  //
  Activity activity;
  Context context;

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "smart_pdf_viewer");
    channel.setMethodCallHandler(this);
    //=========
    context = flutterPluginBinding.getApplicationContext();
    //=========
  }

  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
      openNewActivity();
    } else {
      result.notImplemented();
    }
  }


  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
  }

  @Override
  public void onAttachedToActivity(@NonNull ActivityPluginBinding binding) {
    activity = binding.getActivity();//.addActivityResultListener(delegate);
    binding.getActivity().getApplication();
  }

  @Override
  public void onDetachedFromActivityForConfigChanges() {

  }

  @Override
  public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding binding) {

  }

  @Override
  public void onDetachedFromActivity() {

  }


  //===========================
//  @Override
//  public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
//
//    //setupActivity(activityPluginBinding.getActivity());
//    //this.activityPluginBinding = activityPluginBinding;
//    activity = activityPluginBinding.getActivity();//.addActivityResultListener(delegate);
//   activityPluginBinding.
//  }


  private void openNewActivity() {
    System.out.println("open Activity called=================");
    Intent intent = new Intent(context, PDFViewActivity.class);
    activity.startActivity(intent);
  }
  //===========================
}
