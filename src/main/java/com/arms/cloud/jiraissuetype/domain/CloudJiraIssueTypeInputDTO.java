package com.arms.cloud.jiraissuetype.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CloudJiraIssueTypeInputDTO {
    private String description;
    private String name;
    private String type;
}
