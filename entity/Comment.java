package com.kjm.board.entity;

// 댓글
public class Comment {
	
	private String writerProfileImage;
	private String writerNickname;
	private String writerDatetime;
	private String contents;
	
	public Comment(String writerProfileImage, String writerNickname, String writerDatetime, String contents) {
		this.writerProfileImage = writerProfileImage;
		this.writerNickname = writerNickname;
		this.writerDatetime = writerDatetime;
		this.contents = contents;
	}

	public String getWriterProfileImage() {
		return writerProfileImage;
	}

	public void setWriterProfileImage(String writerProfileImage) {
		this.writerProfileImage = writerProfileImage;
	}

	public String getWriterNickname() {
		return writerNickname;
	}

	public void setWriterNickname(String writerNickname) {
		this.writerNickname = writerNickname;
	}

	public String getWriterDatetime() {
		return writerDatetime;
	}

	public String getContents() {
		return contents;
	}
	
}
