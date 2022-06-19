package com.extprohibit.global.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BasicExtension {

    private Long id;
    private String codeName;
    private LocalDateTime createdAt;

    public BasicExtension(String codeName) {
        this.codeName = codeName;
    }
}
