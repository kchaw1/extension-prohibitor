package com.extprohibit.domain.code.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CodeListResponse {

    private Long id;
    private Long groupId;
    private String name;
    private String description;
    private int orders;
}
