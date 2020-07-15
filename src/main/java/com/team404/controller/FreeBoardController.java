package com.team404.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team404.command.FreeBoardVO;
import com.team404.freeboard.service.FreeBoardService;
import com.team404.util.Criteria;
import com.team404.util.PageVO;

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
	public String freeList(Model model, Criteria cri) {
		//기본
//		ArrayList<FreeBoardVO> list = freeBoardService.getList();
//		model.addAttribute("boardList",list);
//		return "freeBoard/freeList";
		
		//페이징
		ArrayList<FreeBoardVO> list = freeBoardService.getList(cri);
		int total = freeBoardService.getTotal();
		PageVO pageVO = new PageVO(cri, total);
		model.addAttribute("boardList",list);
		model.addAttribute("pageVO",pageVO);
		return "freeBoard/freeList";
	}
	
	//등록화면
	@RequestMapping("/freeRegist")
	public String freeRegist() {
		return "freeBoard/freeRegist";
	}
	
//	//수정화면
//	@RequestMapping("/freeModify")
//	public String freeModify(@RequestParam("bno") int bno, Model model) {
//		model.addAttribute("modify",freeBoardService.getContent(bno));
//		return "freeBoard/freeModify";
//	}
//	
//	//상세화면
//	@RequestMapping("/freeDetail")
//	public String freeDetail(@RequestParam("bno") int bno, Model model) {
//		model.addAttribute("detail",freeBoardService.getContent(bno));
//		return "freeBoard/freeDetail";
//	}
	
	//변경화면 상세화면을 하나로 묶어서 처리가 가능.
	@RequestMapping({"/freeDetail", "/freeModify"})
	public void freeDetail(@RequestParam("bno") int bno, Model model) {
		model.addAttribute("detail",freeBoardService.getContent(bno));
	}
	
	//등록처리
	@RequestMapping(value="/registForm",method=RequestMethod.POST)
	public String registForm(FreeBoardVO vo, RedirectAttributes RA) {
		freeBoardService.regist(vo);
		//등록 성공 여부(msg) - 1회성 사용 가능
		RA.addFlashAttribute("msg", "정상 등록 처리 되었습니다.");
		
		return "redirect:/freeBoard/freeList"; //등록후에 리스트화면으로 리다이렉트;
	}
	
	@RequestMapping("/freeUpdate")
	public String freeUpdate(FreeBoardVO vo, RedirectAttributes RA) {
		int result = freeBoardService.getUpdate(vo);
		if(result == 1) {
			RA.addFlashAttribute("msg", "게시글 수정이 정상 처리되었습니다.");
		} else {
			RA.addFlashAttribute("msg", "게시글 수정에 실패하였습니다.");
		}
		//다시 목록으로 리다이렉트
		return "redirect:/freeBoard/freeList";
	}
	
	@RequestMapping("/freeDelete")
	public String freeDelete(@RequestParam("bno") int bno) {
		freeBoardService.getDelete(bno);
		return "redirect:/freeBoard/freeList";
	}
	
	
}
