package com.tcpip2;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.msg.Msg;

//object Serialization 사용

public class Server {

	int port;
	
	ServerSocket serverSocket;
	Socket socket;
	
	
	public Server() {}
	public Server(int port) {
		this.port=port;
	}
	
	//client에서 값을 는 곳 
	//값이 들어올 때 마다 receiver의 쓰레드 동작함 
	
    class Receiver extends Thread{
    	//받으면 쓰레드가 생성되고
    	//받을 때 마다 스트림이 생성된다. 
    	
    	ObjectInputStream dis;
    	Socket socket = null;
		public Receiver(Socket socket) {
			this.socket=socket;
			try {
				dis = new ObjectInputStream(socket.getInputStream());
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	
		@Override
		public void run() {
			//여기 input이 받아서 처리
			//dis가 null이 아닐 때 까지 계속 루프 돌림 
			
			while(dis !=null) {
				Msg mo =null;
				try {
					mo = (Msg)dis.readObject();
					System.out.println("inputstream");
					if(mo.getMsg().equals("q")) {
						System.out.println(mo.getId()+"client가 나갔습니다.");
						break;
					}
					System.out.println("["+mo.getId()+"]"+mo.getMsg());
				} catch (Exception e) {
					e.printStackTrace();
					break;
				}
			}
			if (dis!=null) {
				try {
					dis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (socket!=null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void startServer() throws Exception {
		
		System.out.println("TCP/IP SERVER START...");
		try {
		serverSocket = new ServerSocket(port); //socket 
		
		while(true) {
			System.out.println("Ready Server...");
			socket = serverSocket.accept(); //while 루프가 계속 돌다가 socket이 기다리는 곳 
		    System.out.println("Connected...");
		    new Receiver(socket).start(); //client가 들어오면 socket이 start한다
		                                  //client 의 수 만큼 소켓 생성 
		                                  //Reciever class
		}
	}catch(Exception e) {
		throw e;
	}
	}
	
	//1.server 함수 생성 
	public static void main(String[] args) {
		Server server = new Server(7777);
		try {
			server.startServer();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
