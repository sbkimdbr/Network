package com.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//class Thread implements Runnable{
//
//	boolean flag = true;
//	public void setFlag(boolean flag) {
//		
//	}
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		
//	}
//	
//}

public class Test3 {
//
	public static void main(String[] args) throws IOException {
		String urlstr = "http://192.168.0.82/web/car.jsp";
		URL url = null;
		HttpURLConnection con = null;
	  
		
		
		
		//5초에 한번씩 데이터를 전송할 수 있도록 
		//trycatch 구문이 while 로 들어가고
		//랜덤 데이터 받기 위해서 Math.random()함수 사용 
		//5초에 한번씩 돌아가도록 thread.sleep 마지막에 적어준다. 
		
		while(true) {
		   
		   try {
				
				double lat = Math.random()*90 +1;
				double lng = Math.random()*90 +1;
				
				//5초에 한번씩 데이터를 서버에 전송한다. 
				
				
				url = new URL(urlstr+"?lat="+lat+"&lng="+lng);
				
				
				con = (HttpURLConnection) url.openConnection();
				con.setReadTimeout(5000);
				con.setRequestMethod("POST");
				con.getInputStream();
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}finally {
				con.disconnect();
			}
		   
		   try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
		
		

	}

}
