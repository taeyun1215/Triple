package dev.triple.domain.review;

import dev.triple.domain.review.constant.ReviewAction;
import dev.triple.domain.review.constant.ReviewType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "review")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private ReviewType type;

    @Column(length = 10, nullable = false)
    private ReviewAction action;

    @Lob
    @Column(nullable = false)
    private String content;

    private List<String> attachedPhotoIds;

    private String userId;

    private String placeId;

    @Builder
    public Review(
            ReviewType type,
            ReviewAction action,
            String content,
            List<String> attachedPhotoIds,
            String userId,
            String placeId
    ) {
        this.type = type;
        this.action = action;
        this.content = content;
        this.attachedPhotoIds = attachedPhotoIds;
        this.userId = userId;
        this.placeId = placeId;
    }

}
