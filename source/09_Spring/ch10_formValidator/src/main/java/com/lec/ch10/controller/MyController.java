package com.lec.ch10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch10.vo.Student;
import com.lec.ch10.vo.StudentValidator;

@Controller
public class MyController {
	@ModelAttribute("cnt")
	public int cnt() { //cnt 값 5로 지정
		return 4;
	}
	
	@RequestMapping(value = "inputForm.do", method = RequestMethod.GET)
	public String inputForm() {
		return "ex/inputForm";
	}
	@RequestMapping(value = "input.do", method = RequestMethod.GET)
	public String input(Student student, Errors err, Model model) {
		// 검증 객체를 통해서 검증 method 호출
		StudentValidator validator = new StudentValidator();
		validator.validate(student, err);
		if(err.hasErrors()) {
			if(err.getFieldError("name") !=null) {
				model.addAttribute("nameError", "name은 필수 입력입니다.");
			}
			if(err.getFieldError("id") !=null) {
				model.addAttribute("idError", "id는 자연수 정수입니다.");
			}
			return "ex/inputForm";
			
		}	
		return "ex/inputResult";
	}
	@RequestMapping(value = "inputForm2.do", method = RequestMethod.GET)
	public String inputForm2() {
		return "quiz/inputForm";
	}
	@RequestMapping(value = "input2.do", method = RequestMethod.GET)
	public String input2(Student student, Errors err, Model model) {
		// 검증 객체를 통해서 검증 method 호출
		StudentValidator validator = new StudentValidator();
		validator.validate(student, err);
		if(err.hasErrors()) {
			if(err.getFieldError("name") !=null) {
				model.addAttribute("nameError", "name은 필수 입력입니다.");
			}
			if(err.getFieldError("kor") !=null) {
				model.addAttribute("korError", "kor는 0~100 사이 정수입니다.");
			}
			if(err.getFieldError("eng") !=null) {
				model.addAttribute("engError", "eng는 0~100 사이 정수입니다.");
			}
			if(err.getFieldError("mat") !=null) {
				model.addAttribute("matError", "mat는 0~100 사이 정수입니다.");
			} 
			return "quiz/inputForm";
			
		}	
		return "quiz/inputResult";
	}


}
