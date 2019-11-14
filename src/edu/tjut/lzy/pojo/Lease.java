package edu.tjut.lzy.pojo;

import java.util.Date;

import edu.tjut.lzy.util.DateFormat;

public class Lease {
	private String clientid;
	private String carid;
	private String name;
	private Date startdate;
	private int rentdays;
	private String method;
	private Date returndate;
	private String state;
	private int deposit;
	private int price;
	private int dayrent;
	private int weekrent;
	private int monthrent;
	private String carnumber;
	public Lease() {
		// TODO Auto-generated constructor stub
	}
	
	public Lease(String clientid, String carid, String carname, Date startdate, int rentdays, String method,
			int state, int deposit, int dayrent, int weekrent, int monthrent,String carnumber) {
		super();
		this.clientid = clientid;
		this.carid = carid;
		this.name = carname;
		this.startdate = startdate;
		this.rentdays = rentdays;
		this.method = method;
		this.deposit = deposit;
		this.dayrent = dayrent;
		this.weekrent = weekrent;
		this.monthrent = monthrent;
		this.carnumber = carnumber;
		int danwei=1;
		int danjia = 0;
		switch (this.method) {
		case "日":
			danwei=1;
			danjia = dayrent;
			break;
		case "周":
			danwei=7;
			danjia = weekrent;
			break;
		case "月":
			danwei=30;
			danjia = monthrent;
			break;
		default:
			break;
		}
		Date rDate = new Date(startdate.getTime()+(long)this.rentdays*danwei*24*60*60*1000L);
		String rString = "";
		switch (state) {
		case 0:
			rString = "租出";
			break;
		case 1:
			rString = "已还";	
					break;
		case 2:
			rString = "超期";
			break;
		default:
			break;
		}
		
		this.state = rString;
		
		this.price = danjia*rentdays;
		
		this.returndate =rDate;
		
	}

	
	public String getCarnumber() {
		return carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}

	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
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
	public void Name(String carname) {
		this.name = carname;
	}
	public String getStartdate() {
		return DateFormat.formatDay(startdate);
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public int getRentdays() {
		return rentdays;
	}
	public void setRentdays(int rentdays) {
		this.rentdays = rentdays;
	}
	public String getMethod() {
		return method;
	}
	public int getPrice() {
		return price;
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



	public void setMethod(String method) {
		this.method = method;
	}
	public String getReturndate() {
		return DateFormat.formatDay(returndate);
	}
	
	public String getState() {
		return state;
	}
	public void setState(int state) {
		String rString = "";
		switch (state) {
		case 0:
			rString = "租出";
			break;
		case 1:
			rString = "已还";	
					break;
		case 2:
			rString = "超期";
			break;
		default:
			break;
		}
		
		this.state = rString;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
//	public static void main(String[] args) {
//		Lease lease = new Lease();
//		lease.setMethod("周");
//		lease.setRentdays(3);
//		lease.setStartdate(new Date());
//		System.out.println(lease.getReturndate());
//	}
}
