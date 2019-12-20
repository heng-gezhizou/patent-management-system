package com.greenism.patent.service.impl;

import com.greenism.patent.dao.CaseDao;
import com.greenism.patent.entity.CaseInfoTarget;
import com.greenism.patent.entity.CaseInformation;
import com.greenism.patent.service.CaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CaseServiceImpl implements CaseService {

    @Autowired
    CaseDao caseDao;

    @Override
    public int addNewCase(CaseInformation caseInformation) {
        return caseDao.insertNewCase(caseInformation);
    }

    @Override
    public CaseInformation getCaseInfoByCaseId(String caseId, String applyNo) {
        return caseDao.getCaseInfoByCaseId(caseId,applyNo);
    }

    @Override
    public CaseInformation getCaseInformation(CaseInfoTarget caseInfoTarget) {
        CaseInformation caseInformation = new CaseInformation();
        BeanUtils.copyProperties(caseInfoTarget,caseInformation);
        return caseInformation;
    }

    @Override
    public void addCase(CaseInformation caseInformation) {
        caseInformation.setBatch("第一批");
        caseInformation.setCreateTime(new Date());
        caseInformation.setUpdateTime(new Date());
        caseInformation.setApplyDate(new Date());
        caseInformation.setIsCheck(1);
        caseInformation.setIsUse(1);
        caseInformation.setIsNew(1);
        caseInformation.setLawStatus("1");
        caseDao.addCase(caseInformation);
    }

    @Override
    public List<CaseInformation> queryAllCase() {
        return caseDao.getAllCase();
    }

    @Override
    public List<CaseInformation> queryCaseByConditions(CaseInformation caseInformation) {
        return caseDao.getCaseByConditions(caseInformation);
    }
}
