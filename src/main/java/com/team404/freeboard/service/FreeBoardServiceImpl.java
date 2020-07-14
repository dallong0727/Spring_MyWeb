package com.team404.freeboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team404.command.FreeBoardVO;
import com.team404.freeboard.mapper.FreeBoardMapper;

@Service("freeBoardService")
public class FreeBoardServiceImpl implements FreeBoardService{
	
	@Autowired
	private FreeBoardMapper freeBoardMapper;
	
	@Override
	public void regist(FreeBoardVO vo) {
		freeBoardMapper.regist(vo);
		
	}

}
