package dev.triple.domain.reviewer;

import dev.triple.domain.review.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewerService {

    private final ReviewerRepository reviewerRepository;

    public int calculatePoint(Review review) {
        int tmpPoint = 0;

        if (!review.getContent().isEmpty()) {
            tmpPoint += 1;
        }

        if (review.getAttachedPhotoIds().isEmpty()) {
            tmpPoint += 1;
        }

        // todo : if 해당 place에 첫 리뷰 만들기

        return tmpPoint;
    }

}
