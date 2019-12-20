package com.greenism.patent.dao;

import com.greenism.patent.entity.CaseInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CaseDao {
    int insertNewCase(CaseInformation caseInformation);

    CaseInformation getCaseInfoByCaseId(@Param("caseId") String caseId, @Param("applyNo") String applyNo );

    void addCase(CaseInformation caseInformation);

    List<CaseInformation> getAllCase();

    List<CaseInformation> getCaseByConditions(@Param("caseInformation") CaseInformation caseInformation);
}
