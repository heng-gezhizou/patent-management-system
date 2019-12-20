package com.greenism.patent.constant;

public class Constants {

    public static final String ERROR = "-1";
    public static final String SUCCESS = "1";
    public static final String ERROR_ADD = "新建失败";
    public static final String EMPTY_CASE_ID = "200101";
    public static final String EMPTY_APPLY_NO = "200102";
    public static final String EMPTY_TARGET_ID = "200103";
    public static final String SAME_CASE_ID_OR_APPLY_NO = "200104";
    public static final String ERROR_GET = "200105";
    private int code;

    public int getCode() {
        return code;
    }

    public Constants(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Companent{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    private String msg;

}
