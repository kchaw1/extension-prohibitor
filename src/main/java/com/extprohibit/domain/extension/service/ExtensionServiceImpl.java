package com.extprohibit.domain.extension.service;

import com.extprohibit.domain.code.api.request.CodeListRequest;
import com.extprohibit.domain.code.service.CodeService;
import com.extprohibit.domain.extension.api.request.BasicExtensionRemoveRequest;
import com.extprohibit.domain.extension.api.request.BasicExtensionSaveRequest;
import com.extprohibit.domain.extension.api.request.CustomExtensionRequest;
import com.extprohibit.domain.extension.api.response.BasicExtensionResponse;
import com.extprohibit.domain.extension.api.response.CustomExtensionResponse;
import com.extprohibit.domain.extension.repository.ExtentionRepository;
import com.extprohibit.global.exeption.DuplicatedCustomExtensionException;
import com.extprohibit.global.exeption.MaxCustomCountEcxeedException;
import com.extprohibit.global.vo.BasicExtension;
import com.extprohibit.global.vo.CustomExtension;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExtensionServiceImpl implements ExtensionService{

    private final int MAX_CUSTOM_NUMBER_COUNT = 200;
    private final ExtentionRepository extentionRepository;
    private final CodeService codeService;

    @Override
    public void saveBasicExtension(BasicExtensionSaveRequest request) {
        extentionRepository.saveBasicExtension(new BasicExtension(request.getCodeName()));
    }

    @Override
    public void removeBasicExtension(BasicExtensionRemoveRequest request) {
        extentionRepository.removeBasicExtension(new BasicExtension(request.getCodeName()));
    }

    @Override
    public List<BasicExtensionResponse> findBasicExtensions() {
        return extentionRepository.findBasicExtensions()
                .stream()
                .map(basic ->
                    new BasicExtensionResponse(basic.getCodeName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomExtensionResponse> findCustomExtensions() {
        return extentionRepository.findCustomExtensions()
                .stream()
                .map(custom -> new CustomExtensionResponse(custom.getExtension(),custom.getOrders()))
                .collect(Collectors.toList());
    }

    @Override
    public void saveCustomExtension(CustomExtensionRequest request) {
        if(MAX_CUSTOM_NUMBER_COUNT <= extentionRepository.findCustomExtensionCount()) {
            throw new MaxCustomCountEcxeedException("최대 저장 개수를 초과하였습니다.");
        } else if(
                0 < extentionRepository.findDuplicateCustomExtension(new CustomExtension(request.getExtension()))) {
            throw new DuplicatedCustomExtensionException("중복된 확장자가 존재합니다.");
        } else if (codeService.findCodeByGroupName(new CodeListRequest("FILE_EXTENSION"))
                                .stream()
                                .anyMatch(code -> code.getName().equals(request.getExtension().toUpperCase()))) {
            throw new DuplicatedCustomExtensionException("기본확장자는 커스텀 확장자로 추가할 수 없습니다.");
        } else {
            extentionRepository.saveCustomExtension(
                    new CustomExtension(request.getExtension().toLowerCase()));
        }
    }

    @Override
    public void removeCustomExtension(CustomExtensionRequest request) {
        extentionRepository.removeCustomExtension(new CustomExtension(request.getExtension()));
    }
}
