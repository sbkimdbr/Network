package com.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Test_3 {

	//str.trim()
	public static void main(String[] args) throws IOException {
		String urlstr = "http://192.168.123.107/network/login.jsp";
		URL url = null;
		HttpURLConnection con = null;
		
		InputStream is =null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		while(true) {
			   
			   try {
					
					String id = "qqq";
					String pwd = "111";
					
					//5초에 한번씩 데이터를 서버에 전송한다. 
					
				
					
					 String str = "";
					    while((str = br.readLine())!= null) {
					     //System.out.println(str);
					    	
					    }
					
					con = (HttpURLConnection) url.openConnection();
					con.setReadTimeout(5000);
					con.setRequestMethod("POST");
					con.getInputStream();
					
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}finally {
					con.disconnect();
					if(br != null) {
						try {
							br.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			   
//			   try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		   }
			
	}

}
