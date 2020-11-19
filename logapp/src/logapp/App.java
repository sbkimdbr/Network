package logapp;

import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class App {

	String url;
	
	public App() {}
	
	public void getData() {
	
	for(int i = 1; i<=100; i++) {
		Random r = new Random();
		double temp = r.nextInt(100);
		
		Temp ttemp = new Temp("t1",temp);
		
		try {
			sendData(ttemp);
			System.out.println(ttemp);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}

	private void sendData(Temp tt) throws Exception {
		
		url = "http://192.168.123.106/log2/tempstatus.mc";
		url+="?Id=" + tt.getId()+"&temp="+tt.getTemp();
		System.out.println(url);
		URL curl=new URL(url);
		
		
		HttpURLConnection con = (HttpURLConnection) curl.openConnection();
		
		try {
			
			con.setReadTimeout(500);

			con.setRequestMethod("POST");
			con.getInputStream();
			con.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.disconnect();
		}

	}
	public static void main(String[] args) {

		App app = new App();
		app.getData();

	}
}		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	