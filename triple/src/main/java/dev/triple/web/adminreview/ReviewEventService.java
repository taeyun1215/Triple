package dev.triple.web.adminreview;

import dev.triple.domain.review.Review;
import dev.triple.domain.review.ReviewService;
import dev.triple.domain.review.constant.ReviewAction;
import dev.triple.domain.review.constant.ReviewPointType;
import dev.triple.domain.reviewEventHistory.ReviewEventHistory;
import dev.triple.domain.reviewEventHistory.ReviewEventHistoryService;
import dev.triple.web.adminreview.dto.ReviewEventDto;
import dev.triple.web.adminreview.dto.ReviewEventHistoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewEventService {

    private final ReviewService reviewService;
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

        if (dto.getContent() != null) {
            Review review = dto.toEntity();
            ReviewEventHistory reviewEventHistory = ReviewEventHistoryDto.toEntity(ReviewAction.ADD, ReviewPointType.CONTENT, review.getUserId());
            reviewEventHistoryService.recordReviewEventHistory(reviewEventHistory);

            reviewService.save(review);
        }

    }

    /* 리뷰 수정 */
    public void modEvent(ReviewEventDto dto) {

    }

    /* 리뷰 삭제 */
    public void deleteEvent(ReviewEventDto dto) {

    }
}
