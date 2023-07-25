package com.arms.cloud.jiraissue.domain;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CloudJiraIssueDTO {
    private ProjectDTO project;
    private IssueTypeDTO issuetype;
    private String summary;
    private String description;
}
