package com.bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbs.pojo.Dictionary;
import com.bbs.service.DictionaryService;

@Controller
@RequestMapping("/data")
public class DictionaryController {

	@Autowired
	private DictionaryService dictionaryService;
	
	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	@RequestMapping("/status")
	@ResponseBody
	public List<Dictionary> status(){
		return dictionaryService.listDictionary();
	}
	
}
