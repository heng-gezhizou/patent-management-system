package com.greenism.patent.service;

import com.greenism.patent.entity.CaseInfoTarget;
import com.greenism.patent.entity.CaseInformation;

import java.util.List;

public interface CaseService {
    int addNewCase(CaseInformation caseInformation);

    CaseInformation getCaseInfoByCaseId(String caseId, String applyNo);

    CaseInformation getCaseInformation(CaseInfoTarget caseInfoTarget);

    void addCase(CaseInformation caseInformation);


    List<CaseInformation> queryAllCase();

    List<CaseInformation> queryCaseByConditions(CaseInformation caseInformation);
}
