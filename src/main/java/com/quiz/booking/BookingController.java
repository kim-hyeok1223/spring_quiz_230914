package com.quiz.booking;

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

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@RequestMapping("/booking")
@Controller
public class BookingController {
	
	@Autowired
	private BookingBO bookingBO;
	
	@GetMapping("/bookingList")
	public String bookingList(Model model) {
		
		//select DB
		List<Booking> bookingList = bookingBO.getBookingList();
		model.addAttribute("bookingList", bookingList);
		
		return "/booking/bookingList";
	}
	// 삭제 - AJAX 요청
	@ResponseBody
	@DeleteMapping("/delete-booking")
	public Map<String, Object> deleteBooking(
			@RequestParam("id") int id) {
		// delete DB
		int rowCount = bookingBO.deleteBookingById(id);
		
		Map<String, Object> result = new HashMap<>();
		if(rowCount > 0) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "삭제하는데 실패함");
		}
		return result;
	}
	
	// 예약하기 화면
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		return "booking/makeBooking";
	}

	// 예약하기 - AJAX요청
	@ResponseBody
	@PostMapping("/make-booking")
	public Map<String,Object> makeBooking(
			@RequestParam("name") String name,
			@RequestParam("date") String date,
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber){
		
		// insert db
		bookingBO.addBookingList(name, date, day, headcount, phoneNumber);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
	
	
	// 예약 확인 화면
	@GetMapping("/check-booking-view")
	public String checkBookingView() {
		return "booking/checkBooking";
	}
	
	// 예약 확인하기
	@ResponseBody
	@PostMapping("/check-booking")
	public Map<String, Object> checkBooking(
			@RequestParam("phoneNumber") String phoneNumber){
		
		//select DB
		// {"code":200, "result":"성공"}
		Map<String, Object> result = new HashMap<>();
		
		Booking booking = bookingBO.getBookingListByPhoneNumber(phoneNumber);
		if(booking == null) {
			// {"code" : 500, "error_message":"예약내역이 존재하지 않습니다."}
			result.put("code", 500);
			result.put("error_message", "예약내역이 존재하지 않습니다.");
		} else {
			result.put("code", 200);
			result.put("result", booking);
		}
		
		return result;
	}

}
