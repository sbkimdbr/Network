package com.tcpip;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//1.구조 작성 
//2.필요한 것 선언 
//client 부분 복사해서 넣어줌 

public class Client {

	String port;
	int ip;
	//소켓 생성 
	Socket socket;
	//데이터 보내기 위한 stream 
    OutputStreamWriter ow;
    BufferedWriter bw;
	
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
	
	//server에 메세지 보내기 위한 구문 
	public void request(String msg) throws IOException {
		try {
	    ow = new OutputStreamWriter(socket.getOutputStream());
		bw = new BufferedWriter(ow);
		bw.write(msg);
		
		}catch(Exception e) {
			throw e;
		}
		
	}
	
	//socket 연결 끊는 부분을
	//함수로 만들어서 여기서 소켓연결을 끊는다 
	public void close() throws IOException { 
		if(bw != null) {
				   bw.close();
			   }
		 if(socket!=null) {
				 socket.close();
			   }
	}
	
	public static void main(String[] args) {
		Client client = null;
		client = new Client("192.168.0.122",9999);
		client.connectServer();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Input msg");
			String msg = sc.nextLine();
			if(msg.equals("q")) {
				try {
					client.close();
				} catch (IOException e) {
				    e.printStackTrace();
				}
				break;
			}
			try {
			client.request(msg);
		}catch(IOException e) {
			e.printStackTrace();
		}
		}
		
		
		
		
		System.out.println("End Client");

	}

}

