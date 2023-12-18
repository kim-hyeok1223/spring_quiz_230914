package com.quiz.lesson03.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.RealEstate;

@Repository
public interface RealEstateMapper {
	public RealEstate selectRealEstatebyId(int id);

	// input : rentPrice output : List<RealEstate>([] or 채워져있거나)
	public List<RealEstate> selectRealEstateListByRentPrice(int rentPrice);
	
	public List<RealEstate> selectRealEstateListByArea(int area);
	
	public List<RealEstate> selectRealEstateListByPrice(int price);
}
