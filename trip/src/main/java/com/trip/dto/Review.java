package com.trip.dto;

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
public class Review {
	private int rid;
	private String custid;
	private int pdid;
	private String rcontent;
	private LocalDate rdate;
}
