package com.trip.test;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trip.dto.Placedet;
import com.trip.frame.ApiUtil2;
import com.trip.service.PlacedetService;



@SpringBootTest
class ApiTests2 {
	
	@Autowired
	PlacedetService service;
	
	@Test
	@ResponseBody
	void contextLoads() {
		JSONParser parser=new JSONParser();
		Object obj=null;	
		
		try {
			for(int i=125510;i<126000;i++) {  // 125510 ~ 129799
				String id=Integer.toString(i);
				obj = parser.parse(ApiUtil2.getData(id));
				JSONObject jo=(JSONObject)obj;
				JSONObject jo1=(JSONObject)jo.get("response");
				JSONObject jo2=(JSONObject)jo1.get("body");
				int joc=Integer.parseInt(jo2.get("totalCount").toString());
				if(joc==1) {
					JSONObject jo3=(JSONObject)jo2.get("items");
					JSONArray ja=(JSONArray)jo3.get("item");
					JSONObject jo4=(JSONObject)ja.get(0);
					String pdname=(String)jo4.get("title");
					String pddesc=(String)jo4.get("overview");
					String pdaddr=(String)jo4.get("addr1");
					String imgname1=(String)jo4.get("firstimage");
					String lat=(String)jo4.get("mapx");
					String lng=(String)jo4.get("mapy");
					Placedet pd=new Placedet(0, 1, pdname, pddesc, pdaddr, imgname1, lat, lng, 0, 0);
					service.register(pd);
				};
			}
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail");
		}
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
