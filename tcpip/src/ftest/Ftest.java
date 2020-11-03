package ftest;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

@WebServlet({ "/Ftest", "/ftest.do" })
public class Ftest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Ftest() {
        super();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			URL url = null;
			try {
				url = new URL("https://fcm.googleapis.com/fcm/send");
			} catch (MalformedURLException e) {
				System.out.println("Error while creating Firebase URL | MalformedURLException");
				e.printStackTrace();
			}
			HttpURLConnection conn = null;
			try {
				conn = (HttpURLConnection) url.openConnection();
			} catch (IOException e) {
				System.out.println("Error while createing connection with Firebase URL | IOException");
				e.printStackTrace();
			}
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-Type", "application/json");

			// set my firebase server key
			conn.setRequestProperty("Authorization", "key="
					+ "AAAAIj1dolk:APA91bHzR81fL6nCzZMY479Aak_tDtVEMuPlZu8DJor0zx670gfBd6XKqJytTaKbOhqenMwntFe_ua7qJwU5WuBN1dMzEAGZSBOPChCvRgPZrrzKfDOQY10lI5JsiaM65Yv_akPBuWW3");

			
			// create notification message into JSON format
			JSONObject message = new JSONObject();
			message.put("to", "/topics/client");
			message.put("priority", "high");
			
			//앱이 꺼져있을  푸시알림창에 뜨는 내용
			JSONObject notification = new JSONObject();
			notification.put("title", "Msg"); //알림창, 안드로이드 콘솔 둘다나옴  
			notification.put("body", "msg");
			message.put("notification", notification);
			
			JSONObject data = new JSONObject();
			data.put("control", "subi");//콘솔창에 출력 
			data.put("data", "msg");//콘솔창출력 
			message.put("data", data);


			try {
				OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
				out.write(message.toString());
				out.flush();
				conn.getInputStream();
				System.out.println("OK...............");

			} catch (IOException e) {
				System.out.println("Error while writing outputstream to firebase sending to ManageApp | IOException");
				e.printStackTrace();
			}	
				
	}

}
