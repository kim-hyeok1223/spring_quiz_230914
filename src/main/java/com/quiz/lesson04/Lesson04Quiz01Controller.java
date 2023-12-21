package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {

	
	@Autowired
	private SellerBO sellerBO;
	
	@GetMapping("/add-seller-view")
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	// DB INSERT => 입력 성공 화면
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl", required = false)String profileImageUrl,
			@RequestParam("temperature") double temperature) {
		
		// db insert
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		return "lesson04/afterAddSeller"; 
		
		//
	}
	
	// 최근 가입자 한명 화면
	// http://localhost/lesson04/quiz01/seller-info-view
	@GetMapping("/seller-info-view")
	public String sellerInfoView(Model model , @RequestParam(value = "id", required = false) Integer id) {
		// db select
		Seller seller = null;
		if (id == null) {
			seller = sellerBO.getLatestSeller();
		} else {
			seller = sellerBO.getSellerById(id);
		}
		
		// model에 담기
		model.addAttribute("seller", seller);
		model.addAttribute("title", "판매자 정보");
		// 응답 화면
		return "lesson04/sellerInfo";
		
		//http://localhost/lesson04/quiz01/seller-info-view?id=1
		
		
	}
	
}
