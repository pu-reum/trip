package com.admin.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Inquiry {
	
	private int inquiryid;
	private String custid;
	private String icate;
	private String icontent;
	private String file;
	private String iprocess;
	private Date rdate;
	
	private MultipartFile img;
}
