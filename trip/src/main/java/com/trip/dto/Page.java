package com.trip.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Page {
	private int pageCount; //출력할 페이지의 사이즈
	private int startPage; //시작 페이지 1~5까지면 1
	private int endPage; //마지막 페이지 1~5까지면 5
	private int end; //실제 마지막 페이지 번호 
	private boolean prev; //이전 페이지 존재 여부 확인 
	private boolean next; //endpage가 end보다 작으면 true 
	private int totalData; //전체 데이터 개수
	private Criteria criteria; //페이지 계산에 필요한  criteria 클래스의 멤버 변수에 대한 정보
	
	public Page() {
		;
	}
	
	public Page(int totalData, int pageCount, Criteria criteria) {
		this.totalData=totalData;
		this.criteria=criteria;
		this.pageCount=pageCount;
		
		this.endPage=(int)(Math.ceil(criteria.getPageNum()*1.0/pageCount))*pageCount;
		this.startPage=endPage - (pageCount-1);
		
		end = (int)(Math.ceil(totalData*1.0/criteria.getTotal()));
		
		if(endPage > end) {
			endPage=end==0?1:end;
		}
		
		prev=startPage>1;
		next =endPage < end;
	}
}
