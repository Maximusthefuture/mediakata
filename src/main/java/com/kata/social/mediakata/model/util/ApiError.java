package com.kata.social.mediakata.model.util;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApiError {

    private LocalDateTime timestamp;

    private String message;

    private String debugMessage;

    private String status;

    public ApiError() {
        timestamp = LocalDateTime.now();
    }

}
