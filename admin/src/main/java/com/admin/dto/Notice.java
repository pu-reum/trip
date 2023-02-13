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
public class Notice {
	private int noid;
	private String adid;
	private String nottitle;
	private String notice;
	private String file;
	private int hit;
	private LocalDate rdate;
}
