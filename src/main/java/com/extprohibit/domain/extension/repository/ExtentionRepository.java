package com.extprohibit.domain.extension.repository;

import com.extprohibit.global.infra.ExtensionMapper;
import com.extprohibit.global.vo.BasicExtension;
import com.extprohibit.global.vo.CustomExtension;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ExtentionRepository {

    private final ExtensionMapper mapper;

    public void saveBasicExtension(BasicExtension basicExtension) {
        mapper.saveBasicExtension(basicExtension);
    }

    public void removeBasicExtension(BasicExtension basicExtension) {
        mapper.removeBasicExtension(basicExtension);
    }

    public List<BasicExtension> findBasicExtensions() {
        return mapper.findBasicExtensions();
    }

    public int findCustomExtensionCount() {
        return mapper.findCustomExtensionCount();
    }

    public List<CustomExtension> findCustomExtensions() {
        return mapper.findCustomExtensions();
    }

    public void saveCustomExtension(CustomExtension customExtension) {
        mapper.saveCustomExtension(customExtension);
    }

    public int findDuplicateCustomExtension(CustomExtension customExtension) {
        return mapper.findDuplicateCustomExtension(customExtension);
    }

    public void removeCustomExtension(CustomExtension customExtension) {
        mapper.removeCustomExtension(customExtension);
    }

    public int findDuplicateBasicExtension(BasicExtension basicExtension) {
        return mapper.findDuplicateBasicExtension(basicExtension);
    }
}
