package com.team404.util;

import lombok.Data;

@Data
public class PageVO {
	//criteria를 받아서 화면에 보여줄 버튼을 계산할 클래스
	private int startPage; //첫페이지 번호
	private int endPage; //마지막페이지 번호
	private boolean prev; //이전버튼
	private boolean next; //다음버튼
	
	private int pageNum; //현재 페이지 번호
	private int amount; //보여질 데이터 개수
	private int total;
			
	public PageVO() {
		
	}
	
	//반드시 cri와 total을 전달
	public PageVO(Criteria cri, int total) {
		//번호, 개수 세팅
		this.pageNum = cri.getPageNum();
		this.amount = cri.getAmount();
		this.total = total;
		
		//끝페이지 계산
		//pageNum이 11일 때 20번이 되야함
		//(int)Math.ceil(조회페이지번호 / 보여질 페이지 수) * 보여질 페이지 수
		this.endPage = (int)(Math.ceil(this.pageNum / 10.0)) * 10;
		
		//처음 페이지
		//끝 페이지 - 보여질 페이지 수 + 1		
		this.startPage = endPage - 10 + 1;
		
		//실제 마지막 번호
		//만약에 총 게시물이 53개라면 끝 페이지 번호는 6까지 처리
		//(int)Math.ceil(총 게시글 수/ 화면에 뿌려지는 데이터 수);
		int realEnd = (int)Math.ceil(this.total/(double)this.amount);
		
		//404개 게시물
		//endPage의 증가 번호는 10, 20, 30, 40, 50...
		//realEnd는 41
		if(this.endPage>realEnd) {
			this.endPage=realEnd;
		}
		
		//이전버튼 활성화 여부
		//startPage는 1, 11, 21, 31, 41...
		//시작버튼이 활성화 되는 경우는 11번 페이지부터
		this.prev = this.startPage > 1;
		
		//다음버튼 활성화 여부
		this.next = realEnd > this.endPage;
	}
}
