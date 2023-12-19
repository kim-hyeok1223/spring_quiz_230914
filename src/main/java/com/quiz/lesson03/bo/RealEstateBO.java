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
	
	// input : area, price   output: List<RealEstate> [] or 채워져있는 리스트
	public List<RealEstate> getRealEstateListByAreaPrice(int area, int price) {
		return realEstateMapper.selectRealEstateListByAreaPrice(area, price);
	}
	// quiz02-1
	// input : Realestate     output : 성공한 행의 개수 (int)
	public int addRealEstate(RealEstate realEstate) {
		return realEstateMapper.insertRealEstate(realEstate);
	}
	// address : 썅떼빌리버 오피스텔 814호
//	area : 45
//	type : 월세
//	price : 100000
//	rentPrice : 120
	// realEstateBO.addRealEstateAsField("썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120)
	public int addRealEstateAsField(int realtorId, String address, int area, String type, int price, Integer rentPrice) {
		return realEstateMapper.insertRealEstateByField(realtorId, address, area, type, price, rentPrice);
	}

}
