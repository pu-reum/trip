package com.trip.dto;

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
public class Placedet {
	private int pdid;
	private int cateid;
	private String pdname;
	private String pddesc;
	private String pdaddr;
	private String imgname1;
	private String imgname2;
	private String imgname3;
	private String imgname4;
	private String imgname5;
	private String pddate;
	private String lat;
	private String lng;
	private int pdlike;
	private int hit;
	private Date rdate;
	
	private String custid;
	
	public Placedet(int pdid, int cateid, String pdname, String pddesc, String pdaddr, String imgname1,
			String lat, String lng, int pdlike, int hit) {
		super();
		this.pdid = pdid;
		this.cateid = cateid;
		this.pdname = pdname;
		this.pddesc = pddesc;
		this.pdaddr = pdaddr;
		this.imgname1 = imgname1;
		this.lat = lat;
		this.lng = lng;
		this.pdlike = pdlike;
		this.hit = hit;
	}

	public Placedet(int pdid, int cateid, String pdname, String pddesc, String pdaddr, String imgname1, String pddate,
			String lat, String lng, int pdlike, int hit) {
		super();
		this.pdid = pdid;
		this.cateid = cateid;
		this.pdname = pdname;
		this.pddesc = pddesc;
		this.pdaddr = pdaddr;
		this.imgname1 = imgname1;
		this.pddate = pddate;
		this.lat = lat;
		this.lng = lng;
		this.pdlike = pdlike;
		this.hit = hit;
	}

	public Placedet(int pdid, int cateid, String pdname, String pddesc, String pdaddr, String imgname1, String imgname2,
			String pddate, String lat, String lng, int pdlike, int hit) {
		super();
		this.pdid = pdid;
		this.cateid = cateid;
		this.pdname = pdname;
		this.pddesc = pddesc;
		this.pdaddr = pdaddr;
		this.imgname1 = imgname1;
		this.imgname2 = imgname2;
		this.pddate = pddate;
		this.lat = lat;
		this.lng = lng;
		this.pdlike = pdlike;
		this.hit = hit;
	}

	public Placedet(int pdid, int pdlike, String custid) {
		super();
		this.pdid = pdid;
		this.pdlike = pdlike;
		this.custid = custid;
	}
}
