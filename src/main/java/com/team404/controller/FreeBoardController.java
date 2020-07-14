package com.team404.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team404.command.FreeBoardVO;
import com.team404.freeboard.service.FreeBoardService;

@Controller
@RequestMapping("freeBoard")
public class FreeBoardController {
	/*
	 * 화면처리 -> 테이블생성 -> 등록처리 
	 * */
	
	@Autowired
	@Qualifier("freeBoardService")
	private FreeBoardService freeBoardService;
	//목록화면
	@RequestMapping("/freeList")
	public String freeList() {
		return "freeBoard/freeList";
	}
	
	//등록화면
	@RequestMapping("/freeRegist")
	public String freeRegist() {
		return "freeBoard/freeRegist";
	}
	
	//수정화면
	@RequestMapping("/freeModify")
	public String freeModify() {
		return "freeBoard/freeModify";
	}
	
	//상세화면
	@RequestMapping("/freeDetail")
	public String freeDetail() {
		return "freeBoard/freeDetail";
	}
	
	//등록처리
	@RequestMapping(value="/registForm",method=RequestMethod.POST)
	public String registForm(FreeBoardVO vo) {
		freeBoardService.regist(vo);
		return "redirect:/freeBoard/freeList"; //등록후에 리스트화면으로 리다이렉트;
	}
}
