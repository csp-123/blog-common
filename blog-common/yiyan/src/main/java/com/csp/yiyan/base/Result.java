package com.csp.yiyan.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;

/**
 * Title:
 * Description:
 * Project: yiyan
 * Author: csp
 * Create Time:2023/1/10 10:59
 */

public class Result<T> implements Serializable {

    private static final long serialVersionUID = -4569216979022946969L;

    //返回数据
    private T data;
    //成功标识
    private boolean isSuccess = false;
    //结果信息
    private String resultMsg = "执行失败!";

    public Result() {

    }

    public static Result fail() {
        return new Result<>();
    }

    public static Result fail(String msg) {
        Result result = fail();
        result.setResultMsg(msg);
        return result;
    }

    public static Result success(String msg) {
        Result result = success();
        result.setResultMsg(msg);
        return result;
    }

    public static Result success() {
        return success(new Result<>());
    }

    public static Result success(Result result) {
        if (result == null) {
            result = new Result();
        }
        result.setResultMsg("执行成功！");
        result.setIsSuccess(true);
        return result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this,
                SerializerFeature.DisableCircularReferenceDetect);
    }


    /**
     * 清空返回数据
     *
     * @return
     */
    public Result clearData() {
        this.data = null;
        return this;
    }



}
