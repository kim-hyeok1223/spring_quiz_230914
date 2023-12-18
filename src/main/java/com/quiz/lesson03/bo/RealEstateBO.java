package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mapper.RealEstateMapper;

@Service
public class RealEstateBO {

	@Autowired
	private RealEstateMapper realEstateMapper;
	
	public RealEstate getRealEstateById(int id) {
		return realEstateMapper.selectRealEstatebyId(id);
	}
	
	// input : rentPrice   output : List<RealEstate>([] or 채워져있거나)
	public List<RealEstate> getRealEstateListByRentPrice(int rentPrice){
		return realEstateMapper.selectRealEstateListByRentPrice(rentPrice);
	}
	
	
	public List<RealEstate> getRealEstateListByArea(int area) {
		return realEstateMapper.selectRealEstateListByArea(area);
	}

	public List<RealEstate> getRealEstateListByPrice(int price) {
		return realEstateMapper.selectRealEstateListByPrice(price);
	}
}
