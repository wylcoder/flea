package com.flea.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> {

    private int status; // 状态码
    private T data; //数据
    private String msg; //封装的错误信息

    private ServerResponse(int status) {
        this.status = status;
    }

    private ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private ServerResponse(int status, T data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }
    /**
     * 接口调用成功
     * */
    public static ServerResponse serverResponseBySuccess(){
        return new ServerResponse(ResponseCode.SUCCESS);
    }

    public static <T> ServerResponse serverResponseBySuccess(T data){
        return new ServerResponse(ResponseCode.SUCCESS, data);
    }

    public static <T> ServerResponse serverResponseBySuccess(T data, String msg){
        return new ServerResponse(ResponseCode.SUCCESS, data, msg);
    }
    /**
     * 接口调用失败
     * */
    public static ServerResponse serverResponseByError(){
        return new ServerResponse(ResponseCode.ERROR);
    }
    public static ServerResponse serverResponseByError(String msg){
        return new ServerResponse(ResponseCode.ERROR, msg);
    }
    public static ServerResponse serverResponseByError(int status){
        return new ServerResponse(status);
    }
    public static ServerResponse serverResponseByError(int status, String msg){
        return new ServerResponse(status, msg);
    }

    /**
     * 判断接口是否正确返回
     * */
    @JsonIgnore
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ServerResponse{" +
                "status=" + status +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
    public static void main(String[] args){
        ServerResponse sp = new ServerResponse(0,"hello");
        ServerResponse sp1 = ServerResponse.serverResponseBySuccess("hello", null);
        System.out.println(sp1);
    }
}
