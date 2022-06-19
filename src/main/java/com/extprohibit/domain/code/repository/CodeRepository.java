package com.extprohibit.domain.code.repository;

import com.extprohibit.global.vo.Code;
import com.extprohibit.global.vo.CodeGroup;
import com.extprohibit.global.infra.CodeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CodeRepository {

    private final CodeMapper mapper;

    public List<Code> findCodeByGroupName(CodeGroup codeGroup) {
        return mapper.findCodeByGroupName(codeGroup);
    }
}
