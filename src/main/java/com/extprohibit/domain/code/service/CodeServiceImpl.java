package com.extprohibit.domain.code.service;

import com.extprohibit.domain.code.api.request.CodeListRequest;
import com.extprohibit.domain.code.api.response.CodeListResponse;
import com.extprohibit.domain.code.repository.CodeRepository;
import com.extprohibit.global.vo.CodeGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CodeServiceImpl implements CodeService{

    private final CodeRepository codeRepository;

    @Override
    public List<CodeListResponse> findCodeByGroupName(CodeListRequest request) {
        return codeRepository.findCodeByGroupName(new CodeGroup(request.getGroupName()))
                .stream()
                .map(
                    code -> new CodeListResponse(
                            code.getId(),
                            code.getGroupId(),
                            code.getName(),
                            code.getDescription(),
                            code.getOrders()))
                .collect(Collectors.toList());
    }
}
