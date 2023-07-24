package com.arms.cloud.jiraproject.domain;

import java.util.Map;

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
public class CloudJiraProjectDTO {
	@JsonProperty("expand")
	private String expand;
	@JsonProperty("self")
	private String self;
	
	@JsonProperty("id")
	private String id;
	@JsonProperty("key")
	private String key;
	@JsonProperty("name")
	private String name;

	@JsonProperty("avatarUrls")
    private Map<String, Object> avatarUrls;

	@JsonProperty("description")
	private String description;

	@JsonProperty("url")
	private String url;
	@JsonProperty("projectTypeKey")
    private String projectTypeKey;
	@JsonProperty("simplified")
    private boolean simplified;
	@JsonProperty("style")
    private String style;
	@JsonProperty("isPrivate")
    private boolean isPrivate;
	@JsonProperty("properties")
    private Map<String, Object> properties;
}
