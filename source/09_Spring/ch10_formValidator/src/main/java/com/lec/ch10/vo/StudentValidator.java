package com.lec.ch10.vo;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import lombok.Data;

@Data
public class StudentValidator implements Validator {
	private String name;
	private int id;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Student.class.isAssignableFrom(clazz); // 검증할 객체의 클래스 타입 명시
	}
	@Override
	public void validate(Object target, Errors err) {
		//컨트롤러에서 호출 : validate (student, err) 호출
		Student student = (Student)target;
		String name = student.getName();
		int id = student.getId();
		int kor = student.getKor();
		int eng = student.getEng();
		int mat = student.getMat();
//		if(name == null || name.trim().isEmpty()) {
//			// name 에러
//			err.rejectValue("name", "no");
//		}
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "name", "no");
		if(id <=0) {
			err.rejectValue("id", "id error");
		}
		if(kor <0 || kor > 100) {
			err.rejectValue("kor", "kor error");
		}
		if(eng <0 || eng > 100) {
			err.rejectValue("eng", "eng error");
		}
		if(mat <0 || mat > 100) {
			err.rejectValue("mat", "mat error");
		}
		
	}
}



