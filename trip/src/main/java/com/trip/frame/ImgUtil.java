package com.trip.frame;

import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class ImgUtil {
	public static void saveFile(MultipartFile mf, String custdir) throws Exception{
		byte [] data;
		String file = mf.getOriginalFilename();
		try {
			data = mf.getBytes();
			
			FileOutputStream fo2 = 
					new FileOutputStream(custdir+file);
			fo2.write(data);
			fo2.close();
		}catch(Exception e) {
			throw e;
		}
		
	}
	
}




