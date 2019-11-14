package edu.tjut.lzy.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import edu.tjut.lzy.dao.DBUtil;
import edu.tjut.lzy.pojo.Car;

@WebServlet("/RentCar")
public class RentCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = "select * from car where state=0";
		ResultSet rSet = DBUtil.execQuery(sql);
		List<Car> cars = new ArrayList<>();
		try {
			while(rSet.next()){
				String carid = rSet.getString("carid");
				String name = rSet.getString("name");
				int dayrent = rSet.getInt("dayrent");
				int weekrent = rSet.getInt("weekrent");
				int monthrent = rSet.getInt("monthrent");
				int deposit = rSet.getInt("deposit");
				String type = rSet.getString("type");
				String color = rSet.getString("color");
				int overdateprice = rSet.getInt("overdateprice");
				
				Car car = new Car(carid, name, dayrent, weekrent, monthrent, deposit, type, color, overdateprice);
				
				cars.add(car);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String resp = JSON.toJSONString(cars);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
