package com.chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import com.msg.Msg;

public class Server {
	
	int port;
	HashMap<String, ObjectOutputStream> maps;
	
    ServerSocket serverSocket;
	
	public Server() {}
	
	public Server(int port) {
		this.port=port;
	    maps = new HashMap<>();
	}
	
	public void startServer() throws Exception {
		//무한루프 돌다가 클라이언트가 들어오면 클라이언트 정보 확인해서 동작된다
		serverSocket=new ServerSocket(port);
		System.out.println("Start Server...");
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
			
				while(true) {
			try {
			Socket socket =null;
			System.out.println("Ready server for socket");
			
			socket = serverSocket.accept();
			System.out.println(socket.getInetAddress());
			
			makeOut(socket);
			new Receiver(socket).start(); //소켓이 만들어 질 때 마다 새로운 쓰레드 생성 받으려면 inputstream필요 이는 소켓에서 생 
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
			}
		};
			
		new Thread(r).start();
		
				
		
	}
	
	//클라이언드가 접속하면 그 클라이언트 수 만큼 소켓생성 됨  
	//소켓의 갯수만큼 아웃풋 스트림 생성되는데 
	//아웃풋 스트림들을 저장하기위해 hashmap에 저장해 놓음 
	public void makeOut(Socket socket) throws IOException {
		ObjectOutputStream oo;
		oo = new ObjectOutputStream(socket.getOutputStream());
		maps.put(socket.getInetAddress().toString(), oo);
		System.out.println("접속자수:"+maps.size());
	}

	//각각의 클라이언트의 쓰레드생성 그 메세지를 받음 
	class Receiver extends Thread{
		Socket socket;
		ObjectInputStream oi;
		public Receiver(Socket socket) throws IOException {
			oi = new ObjectInputStream(socket.getInputStream());
		}
		@Override
		public void run() {
			// 클라이언트의 메세지를 계속 받아야한다
			while(oi != null) {
				Msg msg = null;
				try {
					msg=(Msg)oi.readObject();
					if(msg.getMsg().equals("q")) {
					   
						
						throw new Exception();
					    //강제로 예외 발생시켜서 아래의 catch구문으로 내려가도록 
					}
					
					System.out.println(msg.getMsg());
							
				} catch (Exception e) {
					//여기서 예외되면 클라이언트가 죽은 상태임 
					maps.remove(socket.getInetAddress().toString());
					System.out.println(socket.getInetAddress()+"..Exited");
					System.out.println("접속자수:"+maps.size());
					break;
				} 
			}//end while
			try {
				if(oi!=null) {
					oi.close();
				}
				if(socket!=null) {
					socket.close();
				}
			} catch (Exception e) {
				
			}
		}
		
	}
	
	//sendthread에게 전송하는 역할 
	//리시브가받아서 센드에 던지고 센더 호출 여러명의 해쉬맵의 정보를 꺼내서 전송을 하겠
	public void sendMsg(Msg msg) {
		
	}

	class Sender extends Thread{
		
	}
	
	
	public static void main(String[] args) {
		Server server = new Server(5555);
		try {
			server.startServer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
