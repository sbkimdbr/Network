## day02

- Tcpip 연결 구문
- Http 연결 구문 



### TCP-IP

<img src="/Users/subikim/Library/Application Support/typora-user-images/image-20201028090644145.png" alt="image-20201028090644145" style="zoom: 25%;" />

##### Server와 Client 연결 

> Client

1.**client**생성 

```java
public static void main(String[] args) {
		Client client = new Client("192.168.123.107",7777);
		try {
			client.connect();
			client.request();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
```

2. 필요한 **성분** 구성,   **Constructor** 생성 

```java
public class Client {

	int port;
	String address;
	Socket socket;
  
	public Client() {}
	public Client(String address,int port) {
		this.address=address;
		this.port=port;
	}
```

3. **연결**

   connect 함수 생성

```java
/*
1. socket 연결 
2.Thread 던지고
3. socket 연결 
4.try->연결
5.catch->exception 부분 
*/		
public void connect() throws Exception {
		try {
			socket = new Socket(address,port); 
		} catch (Exception e) {
			while(true) {
				Thread.sleep(2000);
				 try {
					socket = new Socket(address,port);
					System.out.println("Connected...");
					break;
				}  catch (IOException e1) {
					System.out.println("Re-Try...");
				}	
				
			}
		} 
	}
```



4. **소켓에 메세지 보내기**

​    소켓에 보낼 메시지에 대한 함수 생성

```java
public void request() throws IOException{
  Scanner sc = new Scanner(System.in);
		try {
			while(true) {
				System.out.println("[Input Msg:]");
				String msg = sc.nextLine();
			}
      new Sender(msg).start();//소켓은 메시지를 받는다
}
}catch(Exception e) {
			
		}finally {
			sc.close();
			if(socket!=null) {
				socket.close();
			}
		}
```



5. **(소켓의 메시지 스트림으로 Server에 전송)**

   socket이 받은 메세지 server에 전송하는 함수 

```java
//소켓이 받은 메시지를 스트림을 통해 전송한다.
//String msg, DataInputStream 객체 필요
DataOutPutStream dos;
String msg;

public Sender(String msg){
  this.msg = msg;
  try{
    dos = new DataOutPutStream(socket.getOutputStream())
   //socket.getOutputStream() 소켓이 아웃풋스트림으로 내보내는 값 
  }catch (IOException e) {
				e.printStackTrace();
			}
}

//override 생성하여 실행시킨다. 
	@Override
 public void run() {
		if(dos!=null) {
			try {
					dos.writeUTF(msg);
					dos.close();
			} catch (IOException e) {
					e.printStackTrace();
			   }
	   }
  }
}
```

