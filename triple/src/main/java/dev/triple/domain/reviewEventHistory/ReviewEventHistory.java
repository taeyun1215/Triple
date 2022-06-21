package dev.triple.domain.reviewEventHistory;

import dev.triple.domain.review.constant.ReviewAction;
import dev.triple.domain.review.constant.ReviewPointType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "history")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewEventHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ReviewAction action;

    private ReviewPointType pointType;

    private String userId;

    @Builder
    public ReviewEventHistory (
            ReviewAction action,
            ReviewPointType pointType,
            String userId
    ) {
        this.action = action;
        this.pointType = pointType;
        this.userId = userId;
    }

}
