package com.greenism.patent.dao;

import com.greenism.patent.entity.CaseStatus;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CaseStatusDao {
    void addCaseStatus(CaseStatus caseStatus);
}
