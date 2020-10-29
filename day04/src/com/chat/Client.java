package com.chat;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.msg.Msg;

public class Client {
    
	int port;
	String address;
	String id;
	Socket socket;
	Sender sender;
	
	public Client() {}
	public Client(String address,int port, String id) {
		this.address=address;
		this.port=port;
		this.id=id;
			
	}
	
	public void Connect() throws IOException {
		try {
			socket = new Socket(address,port);
		} catch (Exception e) {
			while(true) {
				//System.out.println("Retry...");
				try {
					
					Thread.sleep(2000);
					socket = new Socket(address,port);
					break;
				} catch (Exception e1) {
					System.out.println("Retry...");
				} 
				
			}
		
		}
		System.out.println("Connenected socket of Server...:"+address);
		sender=new Sender(socket);
	}
	
	//스캐너에서 입력되어 보내는 곳 
	//key를 받아서 
	public void sendMsg() {
		Scanner sc= new Scanner(System.in) ;
		while(true) {
			System.out.println("Input MSG");
			String ms = sc.nextLine();
			
			Msg msg = new Msg("",id,ms);
			sender.setMsg(msg);
			new Thread(sender).start(); // 여기서 Sender를 server에 보낸다.
			
			if(ms.equals("q")) {
				break;
			}
		}
		sc.close();
		if(socket!=null) {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    System.out.println("client exited...");
	}
	
	class Sender implements Runnable{
		Socket socket;
		ObjectOutputStream oo ;
		Msg msg;
		public Sender(Socket socket) throws IOException {
			this.socket=socket;
			oo=new ObjectOutputStream(socket.getOutputStream());
			
		}
		
		public void setMsg(Msg msg) {
			this.msg=msg;
		}

		@Override
		public void run() {
			if(oo!=null) {
				try {
					oo.writeObject(msg);//msg전송 
				} catch (IOException e) {
					// server가 죽어있을 확률이 크다 
					e.printStackTrace();
				    try {
				    	
						if(socket!=null) {
							socket.close();
						}
						
					
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		}
		
		
	}
	
    class Receiver extends Thread{
    	
    }
	//서버에서 보내는 메세지도 받아야 한다. 
	
	public static void main(String[] args) {
	
		Client client = new Client("192.168.0.122",5555,"subi");
		try {
			client.Connect();
		    client.sendMsg();//key받아서 메세지 보낸다 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
