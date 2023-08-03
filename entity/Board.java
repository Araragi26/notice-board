package com.kjm.board.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kjm.board.common.BoardIndex;

// 게시물
public class Board {
	
	private int boardNumber;
	private String title;
	private String contents;
	private String writerDatetime;
	private String writerEmail;
	private String writerNickname;
	private String writerProfileImage;
	private int viewCount;
	private List<String> imageList;
	private List<Liky> likeList;
	private List<Comment> commentList;
	
	public Board(String title, String contents, String writerEmail, String writerNickname, String writerProfileImage,
			List<String> imageList) {
		
		Date now = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy. MM. dd. hh: mm: ss");
		
		this.boardNumber = BoardIndex.index++;
		this.title = title;
		this.contents = contents;
		this.writerDatetime = simpleDateFormat.format(now);
		this.writerEmail = writerEmail;
		this.writerNickname = writerNickname;
		this.writerProfileImage = writerProfileImage;
		this.viewCount = 0;
		this.imageList = imageList;
		this.likeList = new ArrayList<Liky>();
		this.commentList = new ArrayList<Comment>();
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getWriterNickname() {
		return writerNickname;
	}

	public void setWriterNickname(String writerNickname) {
		this.writerNickname = writerNickname;
	}

	public String getWriterProfileImage() {
		return writerProfileImage;
	}

	public void setWriterProfileImage(String writerProfileImage) {
		this.writerProfileImage = writerProfileImage;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getBoardNumber() {
		return boardNumber;
	}

	public String getWriterDatetime() {
		return writerDatetime;
	}

	public String getWriterEmail() {
		return writerEmail;
	}

	public List<String> getImageList() {
		return imageList;
	}

	public List<Liky> getLikeList() {
		return likeList;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}
	
	
}
