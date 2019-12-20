package com.greenism.patent.service.impl;

import com.greenism.patent.dao.CaseTargetDao;
import com.greenism.patent.entity.CaseInfoTarget;
import com.greenism.patent.entity.CaseTarget;
import com.greenism.patent.service.CaseTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CaseTargetServiceImpl implements CaseTargetService {

    @Autowired
    CaseTargetDao caseTargetDao;

    @Override
    public void addCaseTarget(CaseInfoTarget caseInfoTarget) {


            CaseTarget caseTarget = new CaseTarget();
            caseTarget.setTargetId(caseInfoTarget.getTargetId());
            caseTarget.setCaseId(caseInfoTarget.getCaseId());
            caseTarget.setCreateTime(new Date());
            caseTarget.setUpdateTime(new Date());
            caseTarget.setIsUse("1");
            caseTargetDao.addCaseTarget(caseTarget);


    }
}
