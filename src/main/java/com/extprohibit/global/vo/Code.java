package com.extprohibit.global.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Code {

    private Long id;
    private Long groupId;
    private String name;
    private String description;
    private String useYn;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private int orders;
}
