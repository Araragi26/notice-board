package com.kjm.board.service;

import com.kjm.board.dto.request.SignInRequestDto;
import com.kjm.board.dto.request.SignUpRequestDto;
import com.kjm.board.dto.response.ResponseEntity;
import com.kjm.board.dto.response.SignInResponse;
import com.kjm.board.dto.response.SignUpResponseDto;

public interface UserService {
	ResponseEntity<SignUpResponseDto> signUp(SignUpRequestDto dto);
	ResponseEntity<SignInResponse> signIn(SignInRequestDto dto);
}
