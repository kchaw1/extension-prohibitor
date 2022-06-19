package com.extprohibit.global.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CustomExtension {

    private Long id;
    private String extension;
    private LocalDateTime createdAt;
    private int orders;

    public CustomExtension(String extension) {
        this.extension = extension;
    }
}
