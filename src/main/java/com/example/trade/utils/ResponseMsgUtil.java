package com.example.trade.utils;

import com.example.trade.dto.ResponseMsg;

/**
 * @author: zhangyue
 * @date: 2020/6/29 10:05
 * @description:
 */
public class ResponseMsgUtil {

    public static ResponseMsg success(Object obj) {
        return ResponseMsg.builder().data(obj).code("10001").msg("success").build();
    }
}
