package dev.triple.domain.reviewEventHistory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewEventHistoryService {

    private final ReviewEventHistoryRepository reviewEventHistoryRepository;

    public void recordReviewEventHistory(ReviewEventHistory reviewEventHistory) {
        reviewEventHistoryRepository.save(reviewEventHistory);
    }
}
