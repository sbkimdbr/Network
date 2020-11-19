package hiveapp;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class App {

	String url;

	public App() {

	}

	// �������� ���̾� �޾ƿ�
	public void getData() {
		for (int i = 1; i <= 1500; i++) {

			Random r = new Random();
			double speed = r.nextInt(200);
			double temp = r.nextInt(100);
			double oiltemp = r.nextInt(100);
			double rpm = r.nextInt(1500);

			CarStatus cstatus = new CarStatus("c01", speed, temp, oiltemp, rpm);

			try {
				sendData(cstatus);
				System.out.println("Send Data..." + speed);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// ������ �����Ѵ�
	public void sendData(CarStatus cs) throws Exception {

		url = "http://192.168.123.106/hive/carstatus.mc";
		url += "?id=" + cs.getId() + "&speed=" + cs.getSpeed() + "&temp=" + cs.getTemp() + "&oiltemp=" + cs.getOiltemp()
				+ "&rpm=" + cs.getRpm();
		System.out.println(url);
		URL curl = new URL(url);

		//ss 값을 받는다고 하면 
		/*   
		  url += "?ss="+ss;
		 * 
		 * */
		HttpURLConnection con =

				(HttpURLConnection) curl.openConnection();
		try {
			con.getInputStream();
			con.setReadTimeout(500);

			con.setRequestMethod("POST");

			con.disconnect();
		} catch (Exception e) {
			// throw e;
		} finally {
			con.disconnect();
		}

	}

	public static void main(String[] args) {

		App app = new App();
		app.getData();

	}

}
