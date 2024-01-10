package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {
	public RealEstate selectRealEstatebyId(int id);

	// input : rentPrice output : List<RealEstate>([] or 채워져있거나)
	public List<RealEstate> selectRealEstateListByRentPrice(int rentPrice);
	
	// input : area, price   output: List<RealEstate> [] or 채워져있는 리스트
	public List<RealEstate> selectRealEstateListByAreaPrice(
			// myBatis 문법 상 파라미터는 단 한개만 xml로 보낼 수 있다.
			// 파라미터들을 하나의 맵에 담아서 보낸다.
			// 맵으로 만들어주는 어노테이션 @Param
			@Param("area") int area,
			@Param("price") int price);
	
	public int insertRealEstate(RealEstate realEstate);
	
	public int insertRealEstateByField(
			@Param("realtorId") int realtorId,
			@Param("address") String address,
			@Param("area") int area,
			@Param("type") String type,
			@Param("price")  int price,
			@Param("rentPrice") Integer rentPrice);
	
	//
	public int updateRealEstateById(
			@Param("id") int id, 
			@Param("type") String type, 
			@Param("price") int price);
	
	public int deleteRealEstateById(int id);
}
