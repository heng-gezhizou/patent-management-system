package com.greenism.patent.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CaseTarget {

    private int id;
    private String caseId;
    private String targetId;
    private Date updateTime;
    private Date createTime;
    private String isUse;
    private String modifierName;

}
