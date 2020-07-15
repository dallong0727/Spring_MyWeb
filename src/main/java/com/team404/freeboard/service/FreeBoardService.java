package com.team404.freeboard.service;

import java.util.ArrayList;

import com.team404.command.FreeBoardVO;
import com.team404.util.Criteria;

public interface FreeBoardService {
	public void regist(FreeBoardVO vo); //글 등록
	public ArrayList<FreeBoardVO> getList(Criteria cri); //글 목록
	public int getTotal();
	public FreeBoardVO getContent(int bno);
	public int getUpdate(FreeBoardVO vo);
	public void getDelete(int bno);
}
