package com.extprohibit.domain.extension.api;

import com.extprohibit.domain.ApiResponse;
import com.extprohibit.domain.extension.api.request.BasicExtensionRemoveRequest;
import com.extprohibit.domain.extension.api.request.BasicExtensionSaveRequest;
import com.extprohibit.domain.extension.api.request.CustomExtensionRequest;
import com.extprohibit.domain.extension.service.ExtensionService;
import com.extprohibit.global.exeption.DuplicatedCustomExtensionException;
import com.extprohibit.global.exeption.MaxCustomCountEcxeedException;
import com.extprohibit.global.vo.BasicExtension;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/extension/custom")
public class CustomExtensionApi {

    private final ExtensionService extensionService;

    @GetMapping
    public ApiResponse findCustomExtensions() {
        return ApiResponse.of(HttpStatus.OK.value(), "OK", extensionService.findCustomExtensions());
    }

    @PostMapping
    public ApiResponse saveCustomExtension(
            @RequestBody @Valid CustomExtensionRequest request
            ) {
        extensionService.saveCustomExtension(request);
        return ApiResponse.of(HttpStatus.OK.value(), "추가되었습니다.", null);
    }

    @DeleteMapping
    public ApiResponse removeCustomExtension(
            @RequestBody @Valid CustomExtensionRequest request
    ) {
        extensionService.removeCustomExtension(request);
        return ApiResponse.of(HttpStatus.OK.value(), "삭제되었습니다.", null);
    }

    @ExceptionHandler(value = {MaxCustomCountEcxeedException.class, DuplicatedCustomExtensionException.class})
    public ApiResponse exception(Exception e) {
        return ApiResponse.of(HttpStatus.BAD_REQUEST.value(), e.getMessage(), null);
    }
}
