package com.admin.frame;

import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class ImgUtil {
	public static void saveFile(MultipartFile mf, String admindir) throws Exception{
		byte [] data;
		String file = mf.getOriginalFilename();
		try {
			data = mf.getBytes();
//			FileOutputStream fo = 
//					new FileOutputStream(custdir+file);
//			fo.write(data);
//			fo.close();
			FileOutputStream fo2 = 
					new FileOutputStream(admindir+file);
			fo2.write(data);
			fo2.close();
		}catch(Exception e) {
			throw e;
		}
		
	}
	
}




