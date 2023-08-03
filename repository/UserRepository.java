package com.kjm.board.repository;

import java.util.ArrayList;
import java.util.List;

import com.kjm.board.entity.User;

public interface UserRepository extends Repository<User, String> {
	
	// 유저 정보를 저장할 User Entity List
	// public static final 지정시 초기화 필수
	public static final List<User> USERS = new ArrayList<User>();
	
	public abstract boolean existsByEmail(String email);
	public abstract boolean existsByTelNumber(String telNumber);
	public abstract boolean existsByNickname(String nickname);
	
}
