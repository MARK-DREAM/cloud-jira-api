package com.arms.cloud.jiraissue.service;

import com.arms.cloud.jiraissue.domain.CloudJiraIssueInputDTO;

public interface CloudJiraIssue {
    public String getIssue();
    public String createIssue(CloudJiraIssueInputDTO cloudJiraIssueInputDTO) throws Exception;
}
