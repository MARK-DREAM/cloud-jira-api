package com.arms.cloud.jiraissue.controller;


import com.arms.cloud.jiraissue.domain.CloudJiraIssueInputDTO;
import com.arms.cloud.jiraissue.service.CloudJiraIssue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = {"/cloud/jira/issue"})
public class CloudJiraIssueController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier("cloudJiraIssue")
    private CloudJiraIssue cloudJiraIssue;

    @ResponseBody
    @RequestMapping(
            value = {"/getIssue.do"},
            method = {RequestMethod.GET}
    )
    public String miningDataToaRMS(ModelMap model, HttpServletRequest request) throws Exception {
        return cloudJiraIssue.getIssue();
    }


    @ResponseBody
    @RequestMapping(
            value = {"/createIssue.do"},
            method = {RequestMethod.POST}
    )
    public String makeIssueForReqAdd(@RequestBody CloudJiraIssueInputDTO cloudJiraIssueInputDTO,
                                                ModelMap model, HttpServletRequest request) throws Exception {
        return cloudJiraIssue.createIssue(cloudJiraIssueInputDTO);
    }

}
