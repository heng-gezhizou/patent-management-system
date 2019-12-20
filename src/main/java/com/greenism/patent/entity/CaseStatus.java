package com.greenism.patent.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CaseStatus {

    private int id;
    private String caseId;
    private String applyNo;
    private Date applyDate;
    private String inventionName;
    private String modifierName;
    private Date createTime;
    private Date updateTime;
    private int isUse;
    private int status;
    private String inventorName;


}
