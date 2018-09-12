package com.speed.product.vo;

import lombok.Data;

@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;
    /**
     * 信息
     */
    private String message;
    /**
     * 具体内容
     */
    private T data;
}
