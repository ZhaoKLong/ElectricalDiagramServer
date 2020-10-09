package com.electricaldiagram.common;

import com.electricaldiagram.exception.ResultDataException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

import static com.electricaldiagram.common.ErrorCode.DEFAULT_ERROR;

/**
 * @author: Zkl
 * @create: 2010-10-09
 * @Description: 封装返回结果集
 */
@ApiModel(value = "ResultData", description = "结果封装")
public class ResultData<T> implements Serializable {
    private static final long serialVersionUID = 7000760666908532411L;

    @ApiModelProperty("响应码")
    private int resultCode;

    @ApiModelProperty("响应消息")
    private String resultMsg;

    @ApiModelProperty("响应数据")
    private T result;

    public ResultData() {

    }

    /**
     * 构造函数
     *
     * @param resultCode 响应码
     */
    public ResultData(int resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * 构造函数
     *
     * @param resultCode 响应码
     * @param resultMsg  响应消息
     */
    public ResultData(int resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    /**
     * 构造函数
     *
     * @param resultCode 响应码
     * @param resultMsg  响应消息
     * @param result     响应数据
     */
    public ResultData(int resultCode, String resultMsg, T result) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.result = result;
    }

    /**
     * 成功
     *
     * @return 成功响应
     */
    public static ResultData success() {
        return new ResultData(ErrorCode.SUCCESS.getCode(), "success");
    }

    /**
     * 成功
     *
     * @param result 响应数据
     * @return 成功响应
     */
    public static ResultData success(Object result) {
        return new ResultData(ErrorCode.SUCCESS.getCode(), "success", result);
    }

    /**
     * 标准错误响应
     *
     * @param errorCode 响应码【枚举】
     * @return 错误响应
     */
    public static ResultData error(ErrorCode errorCode) {
        return new ResultData(errorCode.getCode(), errorCode.getMessage());
    }

    /**
     * 默认错误响应
     *
     * @param message 响应消息
     * @return 错误响应
     */
    public static ResultData error(String message) {
        return new ResultData(DEFAULT_ERROR.getCode(), message);
    }

    /**
     * 半自定义错误响应
     *
     * @param errorCode    响应码【枚举】
     * @param errorMessage 响应消息
     * @return 错误响应
     */
    public static ResultData error(ErrorCode errorCode, String errorMessage) {
        return new ResultData(errorCode.getCode(), errorMessage);
    }

    /**
     * 自定义错误响应
     *
     * @param errorCode 响应码
     * @param message   响应消息
     * @return 错误响应
     */
    public static ResultData error(int errorCode, String message) {
        return new ResultData(errorCode, message);
    }

    /**
     * 异常消息错误
     *
     * @param e 异常消息
     * @return
     */
    public static ResultData resultDataException(ResultDataException e) {
        return new ResultData(e.getErrorCode().getCode(), (StringUtils.isBlank(e.getMessage()) ? e.getErrorCode().getMessage() : e.getMessage()));
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

}
