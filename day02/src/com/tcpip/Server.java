package com.tcpip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    
	//서버동작을 위한 변수 설정 
	int port = 9999; //임의의 포트 설정
	ServerSocket serverSocket;
	Socket socket;
	
	InputStreamReader ir;
	BufferedReader br;
	
	public Server() {
		
	}
	
	public void startServer() throws IOException {
		
		//서버 준비 
		serverSocket = new ServerSocket(port);
		//1.소켓생성 
		//서버가 계속 접속 될 수 있도록 하려면 while루프 넣으면 됨 
	   try {
		   while(true) {
	    System.out.println("Ready Server...");
		
		//누가 들어올때까지는 여기서 멈춰있음 
		socket = serverSocket.accept();
		System.out.println("Connected...");
		
		//2.스트림 생성 
		//연결이 되면 스트림을 만든다. 
		ir = new InputStreamReader(socket.getInputStream()); //만약 여기서 exception 나는 경우를 대비해 trycatch 구문 사용 
		br = new BufferedReader(ir);
		
		//3. 메시지 받아서 출력가능 
		//client에게 메세지 받음 
		String msg="";
		msg=br.readLine();
		System.out.println(msg);
	    }
	   }catch(Exception e) {
		 throw e;  
	   }finally {
		   if(br != null) {
			   br.close();
		   }
		   if(socket!=null) {
			   socket.close();
		   }
	   }
	   
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		Server server =null;
		
		server = new Server();//serverstrart 
		try {
			server.startServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("End Server");
		
		
	}

}
