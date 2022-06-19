package com.extprohibit.domain.code.service;

import com.extprohibit.domain.code.api.request.CodeListRequest;
import com.extprohibit.domain.code.api.response.CodeListResponse;
import com.extprohibit.global.vo.CodeGroup;

import java.util.List;

public interface CodeService {

    List<CodeListResponse> findCodeByGroupName(CodeListRequest request);
}
