package com.gurume.api.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description: 自定义响应数据结构
 * 				这个类是提供给门户，ios，安卓，微信商城用的
 * 				门户接受此类数据后需要使用本类的方法转换成对于的数据类型格式（类，或者list）
 * 				其他自行处理
 * 				200：表示成功
 * 				500：表示错误，错误信息在msg字段中
 * 				501：bean验证错误，不管多少个错误都以map形式返回
 * 				502：拦截器拦截到用户token出错
 * 				555：异常抛出信息
 */

@ApiModel(description = "通用响应返回对象")
@Data
public class JSONResult<T> {

    @ApiModelProperty(value = "响应业务状态；200：成功；500：错误")
    private Integer status;

    @ApiModelProperty(value = "响应消息")
    private String msg;

    @ApiModelProperty(value = "响应数据")
    private T data;


//    public static JSONResult build(Integer status, String msg, Object data) {
//        return new JSONResult(status, msg, data);
//    }
//
    public static<T> JSONResult<T> ok(T data) {
        return new JSONResult<T>(data);
    }

    public static<T> JSONResult<T> ok() {
        return new JSONResult(null);
    }

    public static<T> JSONResult<T> errorMsg(String msg) {
        return new JSONResult(500, msg, null);
    }

    public static<T> JSONResult<T> errorMap(Object data) {
        return new JSONResult(501, "error", data);
    }

    public static<T> JSONResult<T> errorTokenMsg(String msg) {
        return new JSONResult(502, msg, null);
    }

    public static<T> JSONResult<T> errorException(String msg) {
        return new JSONResult(555, msg, null);
    }

    public JSONResult() {

    }

    public JSONResult(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public JSONResult(T data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }



}
