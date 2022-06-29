package dev.triple.domain.reviewer;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "reviewer")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reviewer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private Integer mileage = 0; // 마일리지

    @Builder
    public Reviewer(String userId, Integer mileage) {
        this.userId = userId;
        this.mileage = mileage;
    }

}
