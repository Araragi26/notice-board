package com.kjm.board.dto.response;

import com.kjm.board.entity.User;

public class SignInResponse  {
	
	private int status;
	private String aessage;
	private String email;
	private String nickname;
	private String profileImage;
	
	public SignInResponse (User user) {
		this.email = user.getEmail();
		this.nickname = user.getNickname();
		this.profileImage = user.getProfileImage();
	}

	@Override
	public String toString() {
		return "SignInResponse [status=" + status + ", aessage=" + aessage + ", email=" + email + ", nickname="
				+ nickname + ", profileImage=" + profileImage + "]";
	}
	
	

}
