package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.domain.Bookmark;
import com.quiz.lesson06.mapper.BookmarkMapper;

@Service
public class BookmarkBO {

	//input : title, url    output : x
	
	@Autowired
	private BookmarkMapper bookmarkMapper;
	
	public void addBookmark(String title, String url) {
		bookmarkMapper.insertBookmark(title,url);
	}
	
	public List<Bookmark> getBookmarkList() {
		return bookmarkMapper.selectBookmarkList();
	}
	
	// input:url         output:boolean
	public boolean isDuplicationUrl(String url) {
		// 중복 없음 : [], 중복이면 리스트는 채워짐
		List<Bookmark> bookmarkList = bookmarkMapper.selectBookmarkListByUrl(url);
		return !bookmarkList.isEmpty();
		// return bookmarkList.isEmpty() ? false : true;
	}
	public int deleteBookmarkById(int id) {
		return bookmarkMapper.deleteBookmarkById(id);
	}
}
