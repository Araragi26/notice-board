package com.kjm.board.controller.implement;

import com.kjm.board.controller.UserController;
import com.kjm.board.dto.request.SignInRequestDto;
import com.kjm.board.dto.request.SignUpRequestDto;
import com.kjm.board.dto.response.ResponseEntity;
import com.kjm.board.dto.response.SignInResponse;
import com.kjm.board.dto.response.SignUpResponseDto;
import com.kjm.board.service.UserService;

public class UserControllerImplement implements UserController {
	
	private final UserService userService;
	
	public UserControllerImplement(UserService userService) {
		this.userService = userService;
	}

	@Override
	public ResponseEntity<SignUpResponseDto> signUp(SignUpRequestDto requestDto) {
		
		boolean isValid = requestDto.valid();
		if (!isValid) return ResponseEntity.badRequest();
		
		ResponseEntity<SignUpResponseDto> result = userService.signUp(requestDto);
		return result;
	}

	@Override
	public ResponseEntity<SignInResponse> signIn(SignInRequestDto requestDto) {
		boolean isValid = requestDto.valid();
		if (!isValid) return ResponseEntity.badRequest();
		
		ResponseEntity<SignInResponse> result = userService.signIn(requestDto);
		return result;
	}

}
