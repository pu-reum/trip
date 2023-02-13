package com.admin.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ReplyBoard {
	private int replyno; //댓글 시퀀스
	private String custid;
	private String coment;
	private int postid; //원글 번호
	private LocalDate rdate;
}
