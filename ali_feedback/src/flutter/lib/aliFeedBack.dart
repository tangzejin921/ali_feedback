import 'dart:async';

import 'package:flutter/services.dart';

class AliFeedBack {
  final MethodChannel _channel = const MethodChannel('AliFeedBackPlugin');

  ///
  ///成功 success（void）
  ///失败 err(PlatformException)
  ///
  Future<Null> open(String phone,String name,String idNo) async {
    var extInfo = <String, dynamic>{
      'phone': phone,
      'name': name,
      'idNo': idNo
    };
    return await _channel.invokeMethod('open',extInfo);
  }
    ///
   ///成功 success（int）
   ///失败 err(PlatformException)
   ///
  Future<int> getUnreadCount() async {
    final count = await _channel.invokeMethod('getUnreadCount');
    return count;
  }
}
