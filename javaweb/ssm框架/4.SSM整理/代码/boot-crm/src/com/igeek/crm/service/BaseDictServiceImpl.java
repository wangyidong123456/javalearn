package com.igeek.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igeek.crm.mapper.BaseDictMapper;
import com.igeek.crm.pojo.BaseDict;

@Service
public class BaseDictServiceImpl implements BaseDictService {

	@Autowired
	private BaseDictMapper baseDictMapper;
	
	
	@Override
	public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode) {
		List<BaseDict> bds =baseDictMapper.queryBaseDictByDictTypeCode(dictTypeCode);
		return bds;
	}

}
