package com.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.mapper.DictionaryMapper;
import com.bbs.pojo.Dictionary;
import com.bbs.service.DictionaryService;
@Service
public class DictionaryServiceImpl implements DictionaryService{

	@Autowired
	private DictionaryMapper dictionaryMapper;

	public DictionaryMapper getDictionaryMapper() {
		return dictionaryMapper;
	}

	public void setDictionaryMapper(DictionaryMapper dictionaryMapper) {
		this.dictionaryMapper = dictionaryMapper;
	}

	@Override
	public List<Dictionary> listDictionary() {
		return dictionaryMapper.listDictionary();
	}



	
	
}
