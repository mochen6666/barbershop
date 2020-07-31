package com.bbs.service;

import java.util.List;

import com.bbs.pojo.Dictionary;
import com.bbs.pojo.Vipconsumer;
import com.github.pagehelper.PageInfo;

public interface DictionaryService {

	List<Dictionary> listDictionary();
	
	List<Dictionary> listSex();
    
    List<Dictionary> listZw();
    
    List<Dictionary> listZt();
	
  
    
}
