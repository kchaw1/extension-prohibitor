package com.extprohibit.global.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CodeGroup {

    private Long id;
    private String name;
    private String description;
    private String useYn;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public CodeGroup(String name) {
        this.name = name;
    }
}
