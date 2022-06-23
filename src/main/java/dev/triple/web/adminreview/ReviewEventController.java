package dev.triple.web.adminreview;

import dev.triple.web.adminreview.dto.ReviewEventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/event")
public class ReviewEventController {

    private final ReviewEventService adminReviewService;

    @PostMapping()
    public ResponseEntity save(@RequestBody ReviewEventDto dto) {
        return ResponseEntity.ok(adminReviewService.event(dto));
    }
}
