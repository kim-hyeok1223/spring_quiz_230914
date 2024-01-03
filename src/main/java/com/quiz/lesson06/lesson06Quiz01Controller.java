package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@RequestMapping("/lesson06")
@Controller
public class lesson06Quiz01Controller {

	@Autowired
	private BookmarkBO bookmarkBO;
	
	// 북마크 추가화면
	@GetMapping("/add-bookmark-view")
	public String addBookmarkView() {
		return "/lesson06/addBookmark";
	}
	
	// 북마크 추가 진행
	// DB insert -> AJAX 통신 요청 => 응답값 JSON String
	@ResponseBody
	@PostMapping("/add-bookmark")
	public Map<String, Object> addBookmark(
			@RequestParam("title") String title,
			@RequestParam("url") String url) {
		
		// db insert
		bookmarkBO.addBookmark(title, url);
		
		// "{"code":200, "result":"성공"}"
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		
		return result; // map => JSON String
	}
	// 목록 화면
	@GetMapping("/bookmark-list-view")
	public String afterAddBookmarkView(Model model) {
		// select db
		List<Bookmark> bookmarkList = bookmarkBO.getBookmarkList();
		// model에 담기
		model.addAttribute("bookmarkList", bookmarkList);
		return "lesson06/afterAddBookmark";
	}
	
	//URL 중복확인 - AJAX 요청
	@ResponseBody
	@PostMapping("/is-duplication-url")
	public Map<String, Object> isDuplicationUrl(
			@RequestParam("url") String url) {
		
		// db select
		boolean isDuplication = bookmarkBO.isDuplicationUrl(url);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplication", isDuplication);
		return result;
	}
	
	// 즐겨찾기 삭제 - AJAX 요청
	@ResponseBody
	@DeleteMapping("/delete-bookmark")
	public Map<String, Object> deleteBookmark(
			@RequestParam("id") int id) {
		
		// db delete
		int rowCount = bookmarkBO.deleteBookmarkById(id);
		
		Map<String, Object>  result = new HashMap<>();
		if(rowCount > 0) {			
			result.put("code", 200); // 성공
			result.put("result", "성공");
		} else {
			result.put("code", 500); // 실패
			result.put("error_message", "삭제하는데 실패");
		}
		return result;
	}
}
