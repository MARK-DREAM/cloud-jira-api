package com.arms.cloud.jiraissuetype.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class CloudJiraIssueTypeDTO {
	@JsonProperty("self")
	private String self;
	@JsonProperty("id")
	private String id;
	@JsonProperty("description")
	private String description;
	@JsonProperty("iconUrl")
	private String iconUrl;
	@JsonProperty("name")
	private String name;
	@JsonProperty("untranslatedName")
	private String untranslatedName;
	@JsonProperty("subtask")
	private Boolean subtask;
	@JsonProperty("avatarId")
	private Integer avatarId;
	@JsonProperty("hierarchyLevel")
	private Integer hierarchyLevel;
}
