package com.third.easyprice.exception;

import lombok.Getter;

/**
 * Created with IDEA
 * Date:2019/1/11
 * Time:10:20
 * @author Zhangyibo
 */
@Getter
public class SellException extends RuntimeException {

    private Integer code;
    private String message;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code,String message) {
        this.code = code;
        this.message = message;
    }
}