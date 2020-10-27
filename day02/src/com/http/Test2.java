package com.http;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Test2 {

	//서버 접속해서 파일 받아오기 
	
	public static void main(String[] args) {
		String urlstr = "http://192.168.0.100/web/users.jsp";
		URL url = null;
		URLConnection con =null;
		
		//read file
	    InputStream is= null;
	    BufferedInputStream bis = null;
	    
	    FileOutputStream fos = null;
	    BufferedOutputStream bos = null;
		
		
		try {
			url = new URL(urlstr);
			con=url.openConnection();
			is = con.getInputStream();
			bis = new BufferedInputStream(is,10000000);
			
			fos = new FileOutputStream("new.mp3");
			bos = new BufferedOutputStream(fos);
			
			int data = 0;//데이터는 항상 integer로 받음 
			while((data = bis.read())!= -1){
				bos.write(data);
			}
			//네트워크 연결 후 stream 연결 
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} //url에 connection 하는 구문 
		
		finally {
			if(bos!=null) {
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(bis !=null){
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			}
		}

	}


