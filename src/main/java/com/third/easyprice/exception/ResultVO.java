package com.third.easyprice.exception;

import lombok.Data;

import java.io.Serializable;

/**
 * Created with IDEA
 * author:Zhangyibo
 * Date:2019/1/11
 * Time:10:26
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 8960474786737581150L;

    /**
     * 错误码
     */
    private Integer code;
    /**
     *提示信息
     */
    private String msg;
    /**
     * 具体内容
     */
    private T data;

}