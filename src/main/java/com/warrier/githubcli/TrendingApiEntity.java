package com.warrier.githubcli;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="trending_apis")
public class TrendingApiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String filter_type;
    private LocalDate start_date;
    private LocalDate end_date = null;
    private Integer limit_results;

    public TrendingApiEntity(String filter_type, LocalDate start_date, LocalDate end_date, Integer limit_results) {
        this.filter_type = filter_type;
        this.start_date = start_date;
        this.end_date = end_date;
        this.limit_results = limit_results == null? 10:limit_results;
    }

    public String getFilter_type() {
        return filter_type;
    }

    public void setFilter_type(String filter_type) {
        this.filter_type = filter_type;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public Integer getLimit() {
        return limit_results;
    }

    public void setLimit(Integer limit_results) {
        this.limit_results = limit_results;
    }
}
