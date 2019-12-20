package com.greenism.patent.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CaseLog {

    private int id;
    private Date datetime;
    private String account;
    private String doSomething;
    private String caseId;
    private String fileType;

}
