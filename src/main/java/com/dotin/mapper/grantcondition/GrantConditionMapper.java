package com.dotin.mapper.grantcondition;

import com.dotin.dto.GrantConditionDto;
import com.dotin.model.data.GrantCondition;

/**
 * @author : Bahar Zolfaghari
 **/
public interface GrantConditionMapper {

    GrantCondition toGrantCondition(GrantConditionDto grantConditionDto);
    GrantConditionDto toGrantConditionDto(GrantCondition grantCondition);
}
