package com.extprohibit.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class ApiResponse <T> {

    private final int status;
    private final String message;
    private final T data;

    public static <T> ApiResponse<T> of(int status, String message, T data){
        return new ApiResponse(status, message ,data);
    }
}
