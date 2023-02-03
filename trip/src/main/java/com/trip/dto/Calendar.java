package com.trip.dto;

import java.time.LocalDateTime;
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
public class Calendar {
	private int planid;
	private String custid;
	private String plantitle;
	private String plancon;
	private String planstartdate;
	private String planenddate;
	private LocalDateTime rdate;

	
}