package com.extprohibit.domain.extension.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomExtensionRequest {

    @NotBlank(message = "can't be empty")
    private String extension;
}
