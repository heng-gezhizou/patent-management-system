package com.greenism.patent.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CaseAccount {

    private int id;
    private String accountId;
    private String password;
    private int type;
    private Date updateTime;
    private Date createTime;
    private String modifierName;

}
