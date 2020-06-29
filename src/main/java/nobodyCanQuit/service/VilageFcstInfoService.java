package nobodyCanQuit.service;


import java.io.IOException;
import java.net.URL;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class VilageFcstInfoService  {
	
	String date = new SimpleDateFormat("yyyyMMdd HH").format((new Date(System.currentTimeMillis())));
	String[] base_date = date.split(" ");
	
	
	
	
	
	private String Apiaddress 
	="http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst"
			+ "?serviceKey=zGuDv3a%2FY%2FxXtJPaZ4x2I09BsyEbbwzdzoZ5xxO6VSba6r%2BrvDH7bOkuE3R0c5oe3hdHkLdeoFAdD6oPk48cxw%3D%3D"
			+ "&dataType=json&numOfRows=80&pageNo=1"
			+ "&base_date="+base_date[0]+"&base_time=0500"
			+ "&nx=89&ny=90";

	String a ="";
	
	
	
	public URL getApiUrl() {
		
	try {
		return new URL(Apiaddress);
	}catch(IOException e) {
		return null;
		}
	}
}
