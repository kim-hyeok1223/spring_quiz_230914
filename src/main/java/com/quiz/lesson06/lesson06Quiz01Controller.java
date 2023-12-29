package com.quiz.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;

@RequestMapping("/lesson06/quiz01")
@Controller
public class lesson06Quiz01Controller {

	@Autowired
	private BookmarkBO bookmarkBO;
	
	// 북마크 추가화면
	@GetMapping("add-bookmark-view")
	public String addBookmarkView() {
		return "/lesson06/addBookmark";
	}
	
	// 북마크 추가 진행
	// DB insert -> AJAX 요청
	@ResponseBody
	@PostMapping("/add-bookmark")
	public String addBookmark(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		// db insert
		bookmarkBO.addBookmark(name, url);
		return "성공";
	}
	
//	@GetMapping("/after-add-bookmark-view")
//	public String afterAddBookmarkView() {
//		return "lesson06/afterAddBookmark";
//	}
}
