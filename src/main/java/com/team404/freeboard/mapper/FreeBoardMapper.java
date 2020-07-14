package com.team404.freeboard.mapper;

import java.util.ArrayList;

import com.team404.command.FreeBoardVO;

public interface FreeBoardMapper {
	public void regist(FreeBoardVO vo);
	public ArrayList<FreeBoardVO> getList();
	public FreeBoardVO getContent(int bno);
}
