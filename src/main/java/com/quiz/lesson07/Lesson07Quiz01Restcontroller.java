package com.quiz.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.bo.CompanyBO;
import com.quiz.lesson07.entity.CompanyEntity;

@RequestMapping("/lesson07/quiz01")
@RestController
public class Lesson07Quiz01Restcontroller {

	@Autowired
	private CompanyBO companyBO;
	
	@GetMapping("/save1")
	public CompanyEntity save1() {
		return companyBO.addCompany("넥손", "컨텐츠 게임", "대기업", 3585);
		
	}
	
	@GetMapping("/save2")
	public CompanyEntity save2() {
		return companyBO.addCompany("버블팡", "여신금융업", "대기업", 6834);
	}
	
	@GetMapping("/update")
	public CompanyEntity update(int id, String scale, int headcount) {
		return companyBO.updateCompanyById(2, "중소기업", 34);
	}
	
	@GetMapping("/delete")
	public String delete(int id) {
		
		companyBO.deleteCompanyById(2);
		return "삭제 완료";
	}
}
