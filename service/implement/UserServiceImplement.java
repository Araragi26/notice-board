package com.kjm.board.service.implement;

import com.kjm.board.common.ResponseMessage;
import com.kjm.board.dto.request.SignInRequestDto;
import com.kjm.board.dto.request.SignUpRequestDto;
import com.kjm.board.dto.response.ResponseEntity;
import com.kjm.board.dto.response.SignInResponse;
import com.kjm.board.dto.response.SignUpResponseDto;
import com.kjm.board.entity.User;
import com.kjm.board.repository.UserRepository;
import com.kjm.board.service.UserService;

public class UserServiceImplement implements UserService {
	
	private final UserRepository userRepository;
	
	public UserServiceImplement(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// 아래는 검증 작업
	@Override
	public ResponseEntity<SignUpResponseDto> signUp(SignUpRequestDto dto) {
		
		String email = dto.getEmail();
		String telNumber = dto.getTelNumber();
		String nickname = dto.getNickname();
		
		// 이메일 중복 확인
		boolean hasEmail = userRepository.existsByEmail(email);
		if (hasEmail) return ResponseEntity.badRequest(ResponseMessage.EXISTED_EMAIL);
				
		// 전화번호 중복 확인
		boolean hasTelNumber = userRepository.existsByTelNumber(telNumber);
		if (hasTelNumber) return ResponseEntity.badRequest(ResponseMessage.EXISTED_TEL_NUMBER);
		
		// 닉네임 중복 확인
		boolean hasNickname = userRepository.existsByNickname(nickname);
		if (hasNickname) return ResponseEntity.badRequest(ResponseMessage.EXISTED_NICKNAME);
		
		// Entity 생성
		User user = new User(dto);
		
		// Entity 저장
		boolean result = userRepository.create(user);
		if (!result) return ResponseEntity.internalServerError(ResponseMessage.DATEBEAS_ERROR);
		
		return ResponseEntity.ok();
	}

	@Override
	public ResponseEntity<SignInResponse> signIn(SignInRequestDto dto) {
		
		String email = dto.getEmail();
		String password = dto.getPassword();
		
		// 이메일로 유저정보 찾기
		User user = userRepository.read(email);
		if (user == null) return ResponseEntity.unauthorized();
		
		// 입력한 비밀번호가 저장된 비밀번호와 같은지 비교
		if (!password.equals(user.getPassword()))
			return ResponseEntity.unauthorized();
		
		SignInResponse data = new SignInResponse(user);
		
		return ResponseEntity.ok(data);
	}

}
