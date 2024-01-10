package com.quiz.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.quiz.lesson02.domain.Store;

@Mapper
public interface StoreMapper {

	// input : BO로부터 요청 output: List<Store> => BO에게 
	public List<Store> selectStoreList();
}
