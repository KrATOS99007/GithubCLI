package com.warrier.githubcli.repos;

import com.warrier.githubcli.TrendingApiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrendingApiRepository extends JpaRepository<TrendingApiEntity, Integer> {

}
