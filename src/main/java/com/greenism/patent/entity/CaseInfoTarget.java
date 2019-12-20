package com.greenism.patent.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CaseInfoTarget {

    private int id;
    private String batch;
    private String caseId;
    private String applyNo;
    private Date applyDate;
    private String tecContact;
    private String applyName;
    private String inventionName;
    private String lawStatus;
    private String patentType;
    private String inventorName;
    private String modifierName;
    private String accountId;
    private int isCheck;
    private int isNew;
    private String mark;
    private Date updateTime;
    private Date createTime;
    private int isUse;
    private String targetId;

}
