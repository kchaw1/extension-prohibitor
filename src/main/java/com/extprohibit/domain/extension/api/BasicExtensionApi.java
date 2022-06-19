package com.extprohibit.domain.extension.api;

import com.extprohibit.domain.ApiResponse;
import com.extprohibit.domain.extension.api.request.BasicExtensionRemoveRequest;
import com.extprohibit.domain.extension.api.request.BasicExtensionSaveRequest;
import com.extprohibit.domain.extension.service.ExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/extension/basic")
public class BasicExtensionApi {

    private final ExtensionService extensionService;

    @PostMapping
    public ApiResponse saveBasicExtension(
            @RequestBody @Valid BasicExtensionSaveRequest request
            ) {
        extensionService.saveBasicExtension(request);
        return ApiResponse.of(HttpStatus.OK.value(),"저장되었습니다.", null);
    }

    @DeleteMapping
    public ApiResponse removeBasicExtension(
            @RequestBody @Valid BasicExtensionRemoveRequest request
    ) {
        extensionService.removeBasicExtension(request);
        return ApiResponse.of(HttpStatus.OK.value(), "삭제되었습니다.", null);
    }

    @GetMapping
    public ApiResponse findBasicExtensions() {
        return ApiResponse.of(HttpStatus.OK.value(), "OK", extensionService.findBasicExtensions());
    }

}
