package edu.tjut.lzy.pojo;

public class Car {
	private String carid;
	private String name;
	private int dayrent;
	private int weekrent;
	private int monthrent;
	private int deposit;
	private String type;
	private String color;
	private int overdateprice;
	public Car(String carid, String name, int dayrent, int weekrent, int monthrent, int deposit, String type,
			String color, int overdateprice) {
		super();
		this.carid = carid;
		this.name = name;
		this.dayrent = dayrent;
		this.weekrent = weekrent;
		this.monthrent = monthrent;
		this.deposit = deposit;
		this.type = type;
		this.color = color;
		this.overdateprice = overdateprice;
	}
	public String getCarid() {
		return carid;
	}
	public void setCarid(String carid) {
		this.carid = carid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDayrent() {
		return dayrent;
	}
	public void setDayrent(int dayrent) {
		this.dayrent = dayrent;
	}
	public int getWeekrent() {
		return weekrent;
	}
	public void setWeekrent(int weekrent) {
		this.weekrent = weekrent;
	}
	public int getMonthrent() {
		return monthrent;
	}
	public void setMonthrent(int monthrent) {
		this.monthrent = monthrent;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getOverdateprice() {
		return overdateprice;
	}
	public void setOverdateprice(int overdateprice) {
		this.overdateprice = overdateprice;
	}
	
	
}
