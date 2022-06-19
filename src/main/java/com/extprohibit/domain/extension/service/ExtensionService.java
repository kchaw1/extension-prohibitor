package com.extprohibit.domain.extension.service;

import com.extprohibit.domain.extension.api.request.BasicExtensionRemoveRequest;
import com.extprohibit.domain.extension.api.request.BasicExtensionSaveRequest;
import com.extprohibit.domain.extension.api.request.CustomExtensionRequest;
import com.extprohibit.domain.extension.api.response.BasicExtensionResponse;
import com.extprohibit.domain.extension.api.response.CustomExtensionResponse;
import com.extprohibit.global.vo.CustomExtension;

import java.util.List;

public interface ExtensionService {

    void saveBasicExtension(BasicExtensionSaveRequest request);
    void removeBasicExtension(BasicExtensionRemoveRequest request);
    List<BasicExtensionResponse> findBasicExtensions();

    List<CustomExtensionResponse> findCustomExtensions();
    void saveCustomExtension(CustomExtensionRequest request);
    void removeCustomExtension(CustomExtensionRequest request);
}
