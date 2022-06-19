package com.extprohibit.global.infra;

import com.extprohibit.global.vo.BasicExtension;
import com.extprohibit.global.vo.CustomExtension;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExtensionMapper {

    void saveBasicExtension(@Param("basic") BasicExtension basicExtension);
    void removeBasicExtension(@Param("basic") BasicExtension basicExtension);
    int findDuplicateBasicExtension(@Param("basic") BasicExtension basicExtension);
    List<BasicExtension> findBasicExtensions();

    int findCustomExtensionCount();
    int findDuplicateCustomExtension(@Param("custom") CustomExtension customExtension);
    List<CustomExtension> findCustomExtensions();
    void saveCustomExtension(@Param("custom") CustomExtension customExtension);
    void removeCustomExtension(@Param("custom") CustomExtension customExtension);
}
