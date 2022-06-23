package dev.triple.global.error.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    // 리뷰
    ACTION_NOT_EXISTS(400, "해당 동작은 존재하지 않습니다.")
    ;

    ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    private int status;
    private String message;
}
