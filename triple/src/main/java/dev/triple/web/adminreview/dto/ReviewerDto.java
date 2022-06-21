package dev.triple.web.adminreview.dto;

import dev.triple.domain.reviewer.Reviewer;

public class ReviewerDto {

    private Long id;

    private String userId;

    private Integer mileage;

    public static Reviewer toEntity(String userId, Integer mileage) {
        return Reviewer.builder()
                .userId(userId)
                .mileage(mileage)
                .build();
    }

}
