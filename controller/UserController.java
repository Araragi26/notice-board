package com.kjm.board.controller;

import com.kjm.board.dto.request.SignInRequestDto;
import com.kjm.board.dto.request.SignUpRequestDto;
import com.kjm.board.dto.response.ResponseEntity;
import com.kjm.board.dto.response.SignInResponse;
import com.kjm.board.dto.response.SignUpResponseDto;

public interface UserController {
	ResponseEntity<SignUpResponseDto> signUp(SignUpRequestDto requestDto);	
	ResponseEntity<SignInResponse> signIn(SignInRequestDto  requestDto);
}