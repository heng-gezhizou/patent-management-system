package com.greenism.patent.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CaseFile {

    private String caseId;
    private String filePath;
    private int fileType;
    private int isUse;
    private Date createTime;
    private Date updateTime;


}
