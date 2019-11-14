package edu.tjut.lzy.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import edu.tjut.lzy.dao.DBUtil;
import edu.tjut.lzy.pojo.Lease;


@WebServlet("/GetLeaseInfo")
public class GetLeaseInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public GetLeaseInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Object clientid =  request.getSession().getAttribute("clientid");
//		String clientid = "u001";
		ArrayList<Lease> leaseArray = new ArrayList<Lease>();
		if (clientid!=null) {
			
			String sql = "select lease.clientid,lease.carid,car.carnumber,car.name,lease.startdate,lease.rentdays,lease.method,lease.state,car.deposit,car.dayrent,car.weekrent,car.monthrent from lease,car where lease.carid=car.carid and lease.clientid = '"+clientid+"'";
			ResultSet leases = DBUtil.execQuery(sql);
			try {
				while(leases.next()){
					Lease lease = new Lease((String)clientid, leases.getString("carid"), leases.getString("name"),
							leases.getDate("startdate"), leases.getInt("rentdays"), leases.getString("method"), 
							leases.getInt("state"), leases.getInt("deposit"), leases.getInt("dayrent"),
							leases.getInt("weekrent"),leases.getInt("monthrent"),leases.getString("carnumber") );
					leaseArray.add(lease);
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		String resp = JSON.toJSONString(leaseArray);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(resp);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
