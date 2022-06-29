package dev.triple.web.adminreview;

import dev.triple.domain.review.Review;
import dev.triple.domain.review.ReviewService;
import dev.triple.domain.review.constant.ReviewAction;
import dev.triple.domain.review.constant.ReviewPointType;
import dev.triple.domain.reviewEventHistory.ReviewEventHistory;
import dev.triple.domain.reviewEventHistory.ReviewEventHistoryService;
import dev.triple.domain.reviewer.Reviewer;
import dev.triple.domain.reviewer.ReviewerService;
import dev.triple.web.adminreview.dto.ReviewEventDto;
import dev.triple.web.adminreview.dto.ReviewEventHistoryDto;
import dev.triple.web.adminreview.dto.ReviewerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewEventService {

    private final ReviewService reviewService;
    private final ReviewerService reviewerService;
    private final ReviewEventHistoryService reviewEventHistoryService;

    public void event(ReviewEventDto dto) {
        switch (dto.getAction()) {
            case ADD:
                addEvent(dto);
                break;
            case MOD:
                modEvent(dto);
                break;
            case DELETE:
                deleteEvent(dto);
                break;
            default:
                // TODO: 2022-06-17 예외처리
        }
    }

    /* 리뷰 생성 */
    public void addEvent(ReviewEventDto dto) {
        int curPoint = 0;

        Review review = dto.toEntity();

        // 리뷰마다 로그 저장
        ReviewEventHistory reviewEventHistory = ReviewEventHistoryDto.toEntity(ReviewAction.ADD, ReviewPointType.CONTENT, review.getUserId());
        ReviewEventHistory saveReviewEventHistory = reviewEventHistoryService.recordReviewEventHistory(reviewEventHistory);

        // 리뷰 포인트 추가
        curPoint = reviewerService.calculatePoint(review);

        reviewService.save(review);

    }

    /* 리뷰 수정 */
    public void modEvent(ReviewEventDto dto) {

    }

    /* 리뷰 삭제 */
    public void deleteEvent(ReviewEventDto dto) {

    }
}
