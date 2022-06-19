package com.extprohibit.domain.extension.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasicExtensionRemoveRequest {

    @NotBlank(message = "can't be empty")
    private String codeName;
}
