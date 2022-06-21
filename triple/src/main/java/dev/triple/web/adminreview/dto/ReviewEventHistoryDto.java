package dev.triple.web.adminreview.dto;

import dev.triple.domain.review.constant.ReviewAction;
import dev.triple.domain.review.constant.ReviewPointType;
import dev.triple.domain.reviewEventHistory.ReviewEventHistory;

public class ReviewEventHistoryDto {

    private Long id;

    private ReviewAction action;

    private ReviewPointType pointType;

    private String userId;

    public static ReviewEventHistory toEntity(ReviewAction action, ReviewPointType pointType, String userId) {
        return ReviewEventHistory.builder()
                .action(action)
                .pointType(pointType)
                .userId(userId)
                .build();
    }

    public ReviewEventHistoryDto(ReviewAction action, ReviewPointType pointType, String userId) {
        this.action = action;
        this.pointType = pointType;
        this.userId = userId;
    }

}
