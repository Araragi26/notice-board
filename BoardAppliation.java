package com.kjm.board;

import java.util.Scanner;

import com.kjm.board.controller.UserController;
import com.kjm.board.controller.implement.UserControllerImplement;
import com.kjm.board.dto.request.SignInRequestDto;
import com.kjm.board.dto.request.SignUpRequestDto;
import com.kjm.board.dto.response.ResponseEntity;
import com.kjm.board.dto.response.SignInResponse;
import com.kjm.board.dto.response.SignUpResponseDto;
import com.kjm.board.repository.UserRepository;
import com.kjm.board.repository.implement.UserRepositoryImplement;
import com.kjm.board.service.UserService;
import com.kjm.board.service.implement.UserServiceImplement;

public class BoardAppliation {

	static UserRepository userRepository = new UserRepositoryImplement();
	static UserService userService = new UserServiceImplement(userRepository);
	static UserController userController = new UserControllerImplement(userService);

	public static void main(String[] args) {

		while (true) {

			Scanner scanner = new Scanner(System.in);

			System.out.println("작업 : ");
			String method = scanner.nextLine();

			if (method.equals("end"))break;
			if (method.equals("POST /sign-up")) signUp();
			if (method.equals("POST /sign-in")) signIn();

		}

	}

	static void signUp() {

		Scanner scanner = new Scanner(System.in);

		SignUpRequestDto dto = new SignUpRequestDto();

		try {

			System.out.println("이메일 : ");
			dto.setEmail(scanner.nextLine());

			System.out.println("비밀번호 : ");
			dto.setPassword(scanner.nextLine());

			System.out.println("비밀번호 확인 : ");
			dto.setPasswordCheck(scanner.nextLine());

			System.out.println("닉네임 : ");
			dto.setNickname(scanner.nextLine());

			System.out.println("전화번호 : ");
			dto.setTelNumber(scanner.nextLine());

			System.out.println("주소 : ");
			dto.setAddress(scanner.nextLine());

			System.out.println("상세 주소 : ");
			dto.setAddressDetail(scanner.nextLine());

			System.out.println("개인정보 처리 동의");
			dto.setAgreedPersonal(scanner.nextBoolean());

		} catch (Exception exception) {

			System.out.println("입력 중 오류 발생!");
			return;
		}

		ResponseEntity<SignUpResponseDto> result = userController.signUp(dto);
		System.out.println(result.toString());

	}
	
	static void signIn() {
		Scanner scanner = new Scanner(System.in);
		
		SignInRequestDto dto = new SignInRequestDto();
		
		try {
			System.out.println("이메일 : ");
			dto.setEmail(scanner.nextLine());
			System.out.println("비밀번호 : ");
			dto.setPassword(scanner.nextLine());

		} catch(Exception exception) {
			System.out.println("입력 중 오류 발생!");
			return;
			
		}
		
		ResponseEntity<SignInResponse> result = userController.signIn(dto);
		System.out.println(result.toString());
		
	}

}
