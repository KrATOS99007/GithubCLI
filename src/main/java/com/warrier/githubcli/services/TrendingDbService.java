package com.warrier.githubcli.services;

import com.warrier.githubcli.TrendingApiEntity;
import com.warrier.githubcli.dto.TrendingApi;
import com.warrier.githubcli.repos.TrendingApiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrendingDbService {
    private final TrendingApiRepository trendingApiRepository;

    public void addCallToDatabase(TrendingApi trendingApi) {
        TrendingApiEntity trendingApiEntity = trendingApi.toEntity();
        System.out.println("trendingApiEntity: " + trendingApiEntity);
        trendingApiRepository.save(trendingApiEntity);
    }
}
