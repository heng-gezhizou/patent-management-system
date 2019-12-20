package com.greenism.patent.service.impl;

import com.greenism.patent.dao.CaseStatusDao;
import com.greenism.patent.entity.CaseInformation;
import com.greenism.patent.entity.CaseStatus;
import com.greenism.patent.service.CaseStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CaseStatusServiceImpl implements CaseStatusService {

    @Autowired
    CaseStatusDao caseStatusDao;

    @Override
    public void addCaseStatus(CaseInformation caseInformation) {

        CaseStatus caseStatus = new CaseStatus();
        caseStatus.setCaseId(caseInformation.getCaseId());
        caseStatus.setApplyNo(caseInformation.getApplyNo());
        caseStatus.setApplyDate(new Date());
        caseStatus.setInventionName(caseInformation.getInventionName());
        caseStatus.setCreateTime(new Date());
        caseStatus.setUpdateTime(new Date());
        caseStatus.setIsUse(1);
        caseStatus.setStatus(0);
        caseStatus.setInventorName(caseInformation.getInventorName());
        caseStatusDao.addCaseStatus(caseStatus);
    }
}
