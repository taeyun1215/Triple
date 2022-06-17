package dev.triple.domain.review;

import dev.triple.domain.review.constant.ReviewAction;
import dev.triple.domain.review.constant.ReviewType;
import lombok.AccessLevel;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id", nullable = false)
    private Long placeId;

}
