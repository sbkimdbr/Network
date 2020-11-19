package logapp;

public class Temp {

	String id;
	double temp;

	public Temp() {
	
	}

	public Temp(String id, double temp) {
		this.id = id;
		this.temp = temp;
	}

	public Temp(String id) {
		this.id = id;
	}

	public Temp(double temp) {
		
		this.temp = temp;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	@Override
	public String toString() {
		return "Temp [id=" + id + ", temp=" + temp + "]";
	}

	
	
	
}
