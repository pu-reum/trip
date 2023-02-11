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
public class Course {
	private String cid;
	private String cname;
	private String cdname1;
	private String cdimg1;
	private String cdcontent1;
	private String cdname2;
	private String cdimg2;
	private String cdcontent2;
	private String cdname3;
	private String cdimg3;
	private String cdcontent3;
	private Date rdate;
	
	private MultipartFile img1;
	private MultipartFile img2;
	private MultipartFile img3;
}
