package com.tcpip;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

//1.구조 작성 
//2.필요한 것 선언 
//client 부분 복사해서 넣어줌 

public class Client {

	String port;
	int ip;
	
	Socket socket;
	
	public Client(String port,int ip) {
		this.port=port;
		this.ip=ip;
		
	}
	
	//서버 접속하는 부분 
	public void connectServer() {
	      try {
	    	  
	    	  System.out.println("Start Client");
	    	  
	    socket = new Socket(port,ip); //server가 연결 안되면 여기서 exception 떨어짐 
			  System.out.println("Connected...");
			 
		} catch (Exception e) {
			//connection 하다가 fail 나면 fail이 나는 경우의 대한 코드 작성 
			//다시 연결 시도 
			//계속 반복 시도 - while
			while(true) {
				try {
				
				Thread.sleep(2000);
				socket = new Socket(port,ip);
				System.out.println("Connected...");
				break;
			} catch (Exception e1) {
				System.out.println("ReTry....");
				
			} 
			}
			
			
		} 
	}
	
	public static void main(String[] args) {
		Client client = null;
		client = new Client("192.168.0.100",9999);
		client.connectServer();
		
		System.out.println("End Client");

	}

}
