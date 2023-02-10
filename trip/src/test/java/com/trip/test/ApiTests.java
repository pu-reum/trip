package com.trip.test;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trip.dto.Placedet;
import com.trip.frame.ApiUtil;
import com.trip.service.PlacedetService;


// 맛집 api
@SpringBootTest
class ApiTests {

	@Autowired
	PlacedetService service;
	
	@Test
	@ResponseBody
	void contextLoads() {
		JSONParser parser=new JSONParser();
		Object obj=null;	
		try {
			for(int i=1;i<150;i++) { //1~150
				String pageNo=Integer.toString(i);
				obj = parser.parse(ApiUtil.getData(pageNo));
				System.out.println(obj);
				JSONObject jo=(JSONObject)obj;
				JSONObject jo1=(JSONObject)jo.get("getFoodKr");
				JSONArray ja=(JSONArray)jo1.get("item");
				JSONObject jo2=(JSONObject)ja.get(0);
				String pdname=(String)jo2.get("TITLE");
				String pddesc="tel : "+(String)jo2.get("CNTCT_TEL")+", info : "+(String)jo2.get("ITEMCNTNTS");
				String pdaddr=(String)jo2.get("ADDR1");
				String imgname1=(String)jo2.get("MAIN_IMG_THUMB");
				String imgname2=(String)jo2.get("MAIN_IMG_NORMAL");
				String lat=jo2.get("LAT").toString();
				String lng=(String)jo2.get("LNG").toString();
				String pddate=(String)jo2.get("USAGE_DAY_WEEK_AND_TIME");
				Placedet pd=new Placedet(0, 3, pdname, pddesc, pdaddr, imgname1, imgname2, pddate, lat, lng, 0, 0);
				//System.out.println(pd.toString());
				service.register(pd);
			}
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail");
		}
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
