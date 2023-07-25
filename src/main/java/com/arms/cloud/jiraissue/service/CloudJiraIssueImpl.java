package com.arms.cloud.jiraissue.service;

import com.arms.cloud.jiraissue.domain.CloudJiraIssueInputDTO;
import com.arms.config.CloudJiraConfig;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service("cloudJiraIssue")
public class CloudJiraIssueImpl implements CloudJiraIssue {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier("cloudJiraConfig")
    private CloudJiraConfig cloudJiraConfig;

    @Override
    public String getIssue() {
        final WebClient jiraWebClient = cloudJiraConfig.getJiraWebClient();

        String issueKey = "TEST-11";
        String endpoint = "/rest/api/3/issue/" + issueKey;

        Mono<String> response = jiraWebClient.get()
                .uri(endpoint)
                .retrieve()
                .bodyToMono(String.class);

        String jsonResponse = response.block();

        return jsonResponse;
    }

    @Override
    public String createIssue(CloudJiraIssueInputDTO cloudJiraIssueInputDTO) throws Exception {

        final WebClient jiraWebClient = cloudJiraConfig.getJiraWebClient();

        String endpoint = "/rest/api/2/issue";

        Mono<String> response = jiraWebClient.post()
                .uri(endpoint)
                .bodyValue(cloudJiraIssueInputDTO)
                .retrieve()
                .bodyToMono(String.class);

        String jsonResponse = response.block();

        return jsonResponse;
    }

}
