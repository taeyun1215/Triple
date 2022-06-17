package dev.triple.web.adminreview;

import dev.triple.domain.review.constant.ReviewAction;
import dev.triple.domain.review.constant.ReviewType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ReviewEventDto {

    private ReviewType type = ReviewType.REVIEW;

    private ReviewAction action;

    private String reviewId;

    private String content;

    private List<String> attachedPhotoIds;

    private String userId;

    private String placeId;
}
