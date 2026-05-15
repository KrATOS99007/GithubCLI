package com.warrier.githubcli.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateService {

    private final RestTemplate restTemplate = new RestTemplate();

    public String get(String url) {
        return restTemplate.getForObject(url, String.class);
    }

    public String post(String url, Object body) {
        return restTemplate.postForObject(url, body, String.class);
    }
}
