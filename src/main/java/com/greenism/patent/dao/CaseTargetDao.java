package com.greenism.patent.dao;

import com.greenism.patent.entity.CaseTarget;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CaseTargetDao {

    void addCaseTarget(CaseTarget caseTarget);
}
