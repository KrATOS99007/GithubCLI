package com.warrier.githubcli.controllers;


import com.warrier.githubcli.dto.TrendingApi;
import com.warrier.githubcli.services.RestTemplateService;
import com.warrier.githubcli.services.TrendingDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController()
@RequestMapping("/api/v1/trending-repos")
@RequiredArgsConstructor
public class TrendingController {

    private final RestTemplateService restTemplateservice;
    private final TrendingDbService trendingDbService;

    @PostMapping()
    public Object GetTrendingReposInRange(
            @RequestBody TrendingApi trendingApi,
            @RequestParam Integer limit_results
    ) {
        String github_search_url = "";
        switch (trendingApi.getFilter_type()) {
            case "Before" ->
                    github_search_url = "https://api.github.com/search/repositories?q=created:<=" + trendingApi.getStart_date().toString() + "&sort=stars&order=desc&per_page=" + (limit_results != null ? limit_results : 10);
            case "After" -> {
                github_search_url = "https://api.github.com/search/repositories?q=created:>=" + trendingApi.getStart_date().toString() + "&sort=stars&order=desc&per_page=" + (limit_results != null ? limit_results : 10) ;
            }
            case "Between" -> {
                github_search_url = "https://api.github.com/search/repositories?q=created:" + trendingApi.getStart_date().toString() + ".." + trendingApi.getEnd_date().toString() + "&sort=stars&order=desc&per_page=" + (limit_results != null ? limit_results : 10);
            }
            case "Equals" -> {
                github_search_url = "https://api.github.com/search/repositories?q=created:" + trendingApi.getStart_date().toString() + "&sort=stars&order=desc&per_page=" + (limit_results != null ? limit_results : 10);
            }
        }

        //call the GitHub url
        System.out.println("github_search_url: " + github_search_url);
        String response = restTemplateservice.get(github_search_url);
        trendingApi.setLimit_results(limit_results);
        System.out.println("trendingApi: " + trendingApi);
        trendingDbService.addCallToDatabase(trendingApi);
        return ResponseEntity.ok(response);
    }
}
