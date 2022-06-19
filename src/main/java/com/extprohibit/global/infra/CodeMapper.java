package com.extprohibit.global.infra;

import com.extprohibit.global.vo.Code;
import com.extprohibit.global.vo.CodeGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CodeMapper {

    List<Code> findCodeByGroupName(@Param("codeGroup") CodeGroup codeGroup);
}
