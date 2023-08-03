package com.kjm.board.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternValidator {
	
	// 이메일 정규식 (구글 검색)
	public static final String EMAIL_REGEX =
	        "^[a-zA-Z0-9_+&*-]+(?:\\." +
	        "[a-zA-Z0-9_+&*-]+)*@" +
	        "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
	        "A-Z]{2,7}$";
	
	// 전화번호 정규식
	public static final String TEL_NUMBER_REGEX = "^[0-9]{11,12}$";
	
	public static boolean isValidEmail(String email) {
		Pattern pattern = Pattern.compile(EMAIL_REGEX);
		Matcher matcher = pattern.matcher(email);
		boolean emailCheck = matcher.matches();
		return emailCheck;
		
	}
	public static boolean isValidTelNumber(String telNumber) {
		Pattern pattern = Pattern.compile(TEL_NUMBER_REGEX);
		Matcher matcher = pattern.matcher(telNumber);
		boolean telNumberCheck = matcher.matches();
		return telNumberCheck;
	}

}
