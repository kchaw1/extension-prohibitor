package com.extprohibit.domain.code.api;

import com.extprohibit.domain.ApiResponse;
import com.extprohibit.domain.code.api.request.CodeListRequest;
import com.extprohibit.domain.code.service.CodeService;
import com.extprohibit.global.vo.CodeGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/code")
public class CodeApi {

    private final CodeService codeService;

    @PostMapping
    public ApiResponse findCodeByGroupName(@RequestBody @Valid CodeListRequest request) {
        return ApiResponse.of(HttpStatus.OK.value(), "OK", codeService.findCodeByGroupName(request));
    }
}
