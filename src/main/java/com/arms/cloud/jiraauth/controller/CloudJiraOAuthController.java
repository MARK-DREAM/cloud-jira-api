package com.arms.cloud.jiraauth.controller;

import com.arms.cloud.jiraauth.service.CloudJiraOAuth;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = {"/cloud/jira/oauth"})
@RequiredArgsConstructor
public class CloudJiraOAuthController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private CloudJiraOAuth cloudJiraOAuth;

    @Autowired
    public CloudJiraOAuthController(CloudJiraOAuth cloudJiraOAuth) {
        this.cloudJiraOAuth = cloudJiraOAuth;
    }

    @ResponseBody
    @RequestMapping(
            value = {"/cloudJiraAuthorization.do"},
            method = {RequestMethod.GET}
    )
    public void cloudJiraAuthorization(ModelMap model, HttpServletRequest request,
                                  HttpServletResponse response) throws Exception {
        logger.info("Jira Cloud PROJECT GET API 호출");
        String autorizationUrl = "https://auth.atlassian.com/authorize?audience=api.atlassian.com&client_id=h3G2k7xZbgBt5odGcGvKrqYhhIvtFTLh&scope=read%3Ajira-work%20manage%3Ajira-project%20manage%3Ajira-configuration%20read%3Ajira-user%20write%3Ajira-work%20manage%3Ajira-webhook%20manage%3Ajira-data-provider&redirect_uri=http%3A%2F%2Flocalhost%3A31313%2Fcloud%2Fjira%2Foauth%2Fcallback&state=${YOUR_USER_BOUND_VALUE}&response_type=code&prompt=consent";
        logger.info("Jira Cloud cloudJiraAuthorization API 호출 끝");
        response.sendRedirect(autorizationUrl);
    }

    @ResponseBody
    @RequestMapping(
            value = {"/callback"},
            method = {RequestMethod.GET}
    )
    public String callback(HttpServletRequest requset,
                           @RequestParam("state") String state,
                           @RequestParam("code") String code) throws Exception {
        logger.info("code :"+code);
        String accessToken = cloudJiraOAuth.cloudJiraAccessToken(code, requset);

        return accessToken;
    }
}