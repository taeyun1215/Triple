package dev.triple.web.adminreview;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewEventService {

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

    }

    /* 리뷰 수정 */
    public void modEvent(ReviewEventDto dto) {

    }

    /* 리뷰 삭제 */
    public void deleteEvent(ReviewEventDto dto) {

    }
}
