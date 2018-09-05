package com.igeek.crm.mapper;

import com.igeek.crm.pojo.BaseDict;
import com.igeek.crm.pojo.BaseDictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseDictMapper {
	List<BaseDict> queryBaseDictByDictTypeCode(String dict_type_code);
}