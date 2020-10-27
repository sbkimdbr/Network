package com.http;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Test1 {

	//P.682 URL CLASS 
	//브라우저에 접속해서 response 결과를 받아오겠다 
	public static void main(String[] args) {
		String urlstr = "http://192.168.123.107/network1/users.jsp";
		URL url = null;
		URLConnection con =null;
		
		InputStream is =null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			url = new URL(urlstr);
			con=url.openConnection();
			//네트워크 연결 후 stream 연결 
			is = con.getInputStream();
			isr = new InputStreamReader(is,"UTF-8");
			br = new BufferedReader(isr);
			
		   
		    String str = "";
		    while((str = br.readLine())!= null) {
		     //System.out.println(str);
		    	
		    }
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} //url에 connection 하는 구문 
		
		finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		
	}

}
