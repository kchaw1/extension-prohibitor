package com.extprohibit.domain.extension.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomExtensionResponse {

    private String extension;
    private int orders;
}
