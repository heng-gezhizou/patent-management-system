package com.greenism.patent.controller;

import com.greenism.patent.constant.Constants;
import com.greenism.patent.entity.CaseInfoTarget;
import com.greenism.patent.entity.CaseInformation;
import com.greenism.patent.entity.CaseTarget;
import com.greenism.patent.service.CaseService;
import com.greenism.patent.service.CaseStatusService;
import com.greenism.patent.service.CaseTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class CaseController {

    @Autowired
    CaseService caseService;

    @Autowired
    CaseStatusService caseStatusService;

    @Autowired
    CaseTargetService caseTargetService;

    @PostMapping("/addNewCase")
    public Map<String,Object> addNewCase(@RequestBody() CaseInfoTarget caseInfoTarget){

        Map<String,Object> map = new HashMap<>();
        if(caseInfoTarget.getCaseId() == null || "".equals(caseInfoTarget.getCaseId().trim())){
            map.put(Constants.EMPTY_CASE_ID,"case_id不能为空");
            return map;
        }
        if(caseInfoTarget.getApplyNo() == null || "".equals(caseInfoTarget.getApplyNo().trim())){
            map.put(Constants.EMPTY_APPLY_NO,"apply_no不能为空");
            return map;
        }
        if(caseInfoTarget.getTargetId() == null || "".equals(caseInfoTarget.getTargetId())){
            map.put(Constants.EMPTY_TARGET_ID,"target_id不能为空");
            return map;
        }
        if(caseService.getCaseInfoByCaseId(caseInfoTarget.getCaseId(),caseInfoTarget.getApplyNo()) != null){
            map.put(Constants.SAME_CASE_ID_OR_APPLY_NO,"案件文号或者申请号重复");
            return map;
        }
        CaseInformation caseInformation = caseService.getCaseInformation(caseInfoTarget);

        //初始化case_status表
        caseStatusService.addCaseStatus(caseInformation);

        caseTargetService.addCaseTarget(caseInfoTarget);

        //新增专利信息
        caseService.addCase(caseInformation);

        map.put(Constants.SUCCESS,"成功");
        return map;

    }

    @GetMapping("/getAllCase")
    public Map<String,Object> getAllCase(){

        Map<String,Object> map = new HashMap<>();
        List<CaseInformation> list = new ArrayList<>();
        list = caseService.queryAllCase();
        if(list.isEmpty()){
            map.put(Constants.ERROR_GET,"没有查询到数据，请重试");
            return map;
        }

        map.put(Constants.SUCCESS,list);
        return map;
    }

    @PostMapping("/getCaseByConditions")
    public Map<String,Object> getCaseByConditions(@RequestBody() CaseInformation caseInformation){

        Map<String,Object> map = new HashMap<>();
        List<CaseInformation> list = new ArrayList<>();
        list = caseService.queryCaseByConditions(caseInformation);
        if(list.isEmpty()){
            map.put(Constants.ERROR_GET,"没有查到相关的数据，请重新输入条件");
            return map;
        }
        //已被认领的数据
        List<CaseInformation> claimList = new ArrayList<>();
        //未被认领的数据
        List<CaseInformation> unClaimList = new ArrayList<>();
        for (CaseInformation ll : list) {
            if(ll.getIsCheck() == 2){
                if(ll.getModifierName() == null || "".equals(ll.getModifierName())){
                    unClaimList.add(ll);
                }else{
                    claimList.add(ll);
                }
            }
        }

        map.put("claim",claimList);
        map.put("unClaimList",unClaimList);
        return map;
    }



}
