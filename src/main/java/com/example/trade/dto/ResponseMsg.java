package com.example.trade.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author: zhangyue
 * @date: 2020/6/29 09:57
 * @description:
 */
@Data
@Builder
public class ResponseMsg<T> {

    private String code;

    private String msg;

    private Integer count;

    private Object data;

}
