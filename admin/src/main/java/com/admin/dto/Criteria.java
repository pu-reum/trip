package com.admin.dto;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

@Component
@Data
public class Criteria {
	private int pageNum;
	private int total;
	private String searchKey;
	private String searchWord;
	
	// 1 페이지에 5개씩 보여줌
	public Criteria() {
		this(1,5);
	}
	
	public Criteria(int pageNum, int total) {
		this.pageNum=pageNum;
		this.total=total;
	}
	// UriComponentsBuilder : url 생성 도와줌
	public String getListLink() {
		UriComponentsBuilder ucb= UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", pageNum)
				.queryParam("total", total);
		
		return ucb.toUriString();
	}
	
	public String[] getTypeArr() {
		return searchKey == null ? new String[]{} : searchKey.split("");
	}
}
