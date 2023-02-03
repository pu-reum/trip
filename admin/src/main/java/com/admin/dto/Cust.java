package com.admin.dto;

import java.util.Date;

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
public class Cust {
	private String custid;
	private String custpwd;
	private String custname;
	private String custnick;
	private String custphone;
	private String custemail;
	private Date rdate;
	
}
