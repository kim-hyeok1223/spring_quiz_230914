package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lesson01/quiz02")
public class Lesson01Quiz02Controller {

	// 리스트 생성
	 
	 
	// 리스트에 map 입력
	
	// 반복문 이용 map 출력
	
	// http://localhost:8080/lesson01/quiz02/1
	@RequestMapping("/1")
	public List<Map<String, String>> quiz02_1() {
		
		List<Map<String, String>> list = new ArrayList<>();
//		 Map<String, String> map = new HashMap<String, String>() {{ put("rate", "15"); put("director", "봉준호"); put("time", "131"); put("title", "기생충"); }};
//		 list.add(map);
		 
		 Map <String, String> map = new HashMap<>();
			map.put("rate", "15");
			map.put("director", "봉준호");
			map.put("time", "131");
			map.put("title", "기생충");
		 list.add(map);
		
		 Map <String, String> map1 = new HashMap<>();
			map1.put("rate", "0");
			map1.put("director", "로베르토 베니니");
			map1.put("time", "116");
			map1.put("title", "인생은 아름다워");
		 list.add(map1);
		 
		 Map <String, String> map2 = new HashMap<>();
			map.put("rate", "12");
			map.put("director", "크리스토퍼 논란");
			map.put("time", "147");
			map.put("title", "인셉션");
		 list.add(map2);
		 
		 Map <String, String> map3 = new HashMap<>();
			map.put("rate", "19");
			map.put("director", "윤종빈");
			map.put("time", "133");
			map.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		 list.add(map3);
		
		 Map <String, String> map4 = new HashMap<>();
			map.put("rate", "15");
			map.put("director", "프란시스 로렌스");
			map.put("time", "137");
			map.put("title", "헝거게임");
		 list.add(map4);	
	
		 return list;
		 
	}
	// http://localhost:8080/lesson01/quiz02/2
	// 리스트 만들고
	// setter로 정보 넣고
	// 리스트 출력
	
	
	
	@RequestMapping("/2")
	public List<Board> quiz02_2() {
		List<Board> list = new ArrayList<>();
		Board board = new Board();
		board.setTitle("가입인사드립니다.");
		board.setUser("김진혁");
		board.setContent("안녕하세요! 가입인사드립니다. 잘부탁드려요");
		list.add(board);
		
		board = new Board();
		board.setTitle("가입인사요");
		board.setUser("ㅂㅈㄷㄱ");
		board.setContent("안녕 가입인사드립니다. 잘부탁해");
		list.add(board);
		
		board = new Board();
		board.setTitle("가입이요");
		board.setUser("김진혁1233");
		board.setContent("ㅎㅇ");
		list.add(board);
		return list;
	}
	
	@RequestMapping("/3")
	public ResponseEntity<Board> quiz02_3() {
		
		Board board = new Board();
		board.setTitle("가입인사드립니다.");
		board.setUser("김진혁");
		board.setContent("안녕하세요! 가입인사드립니다. 잘부탁드려요");
		
		return new ResponseEntity<>(board, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
}
