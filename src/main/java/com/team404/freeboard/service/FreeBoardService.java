package com.team404.freeboard.service;

import java.util.ArrayList;

import com.team404.command.FreeBoardVO;

public interface FreeBoardService {
	public void regist(FreeBoardVO vo); //글 등록
	public ArrayList<FreeBoardVO> getList(); //글 목록
	public FreeBoardVO getContent(int bno);
}
