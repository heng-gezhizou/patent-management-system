package com.greenism.patent.result;

public class Result<T> {

    private int code;
    private String msg;
    private T data;

    /**
     * 成功时候的调用
     * */
    public static <T> Result<T> success(T data){
        return new  Result<>(data);
    }

    /**
     * 失败时候的调用
     * */
    public static <T> Result<T> error(String message){
        return new  Result<>(message);
    }

    private Result(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

    private Result(String message) {
        if(message == null) {
            return;
        }
        this.code = -1;
        this.msg = message;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
    public T getData() {
        return data;
    }

}
