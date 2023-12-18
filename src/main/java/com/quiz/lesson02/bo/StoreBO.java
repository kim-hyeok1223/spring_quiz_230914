package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.domain.Store;
import com.quiz.lesson02.mapper.StoreMapper;

@Service
public class StoreBO {  // 중간 브로커

	// input : X 컨트롤러로부터 요청       output: List<Store> => 컨트롤러로 ㄱㄱ
	
	@Autowired
	private StoreMapper StoreMapper;
	
	public List<Store> getStoreList() {
		return StoreMapper.selectStoreList();
	}
}
