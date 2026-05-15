package com.warrier.githubcli.dto;

import com.warrier.githubcli.TrendingApiEntity;
import lombok.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TrendingApi {
    private LocalDate start_date;
    private LocalDate end_date;
    private String filter_type;
    private Integer limit_results = 10;

    public TrendingApiEntity toEntity() {
        return TrendingApiEntity.builder()
                .filter_type(this.filter_type)
                .start_date(this.start_date)
                .end_date(this.end_date)
                .limit_results(this.limit_results)
                .build();
    }
}
