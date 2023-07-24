package com.arms.config;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class CloudJiraConfig {
    @Value("${cloud.jira.baseurl}")
    public String jiraUrl;

    @Value("${cloud.jira.id}")
    public String jiraID;

    @Value("${cloud.jira.pass}")
    public String jiraPass;

    @Value("${cloud.jira.projectKey}")
    public String projectKey;

    @Value("${cloud.jira.apiVersion}")
    public String apiVersion;

    @Bean
    public WebClient getJiraWebClient() {
        return WebClient.builder()
                .baseUrl(jiraUrl)
                .defaultHeader("Authorization", "Basic " + getBase64Credentials(jiraID, jiraPass))
                .build();
    }

    private String getBase64Credentials(String jiraID, String jiraPass) {
        String credentials = jiraID + ":" + jiraPass;
        return new String(Base64.getEncoder().encode(credentials.getBytes()));
    }
}
