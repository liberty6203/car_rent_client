package edu.tjut.lzy.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.tjut.lzy.dao.DBUtil;
import edu.tjut.lzy.util.DateFormat;
import edu.tjut.lzy.util.WebResponse;

/**
 * Servlet implementation class ConfirmRentCar
 */
@WebServlet("/ConfirmRentCar")
public class ConfirmRentCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object clientid = request.getSession().getAttribute("clientid");
		String carid = (String)request.getParameter("carid");
		
		String method = (String )request.getParameter("method");
		String rentdays = request.getParameter("rentdays");
		String price = request.getParameter("price");
		if (clientid == null) {
			WebResponse.returnFailureMsg(response, "请先登录");
		}else {
			String sql = "select * from car where carid = '"+carid+"' and state=0";
			ResultSet rSet = DBUtil.execQuery(sql);
			try {
				if (rSet.next()) {
					String insertsql = "insert into lease values('"+clientid+"','"+carid+"','"+DateFormat.formatDay(new Date())+"',"+rentdays+
							",'"+method+"',"+price+",0)";
//					String updatesql = "update car set state=1 where carid='"+carid+"'";
					int isInsert = DBUtil.execUpdate(insertsql);
//					int isUpdate = DBUtil.execUpdate(updatesql);
					if (isInsert>0 ) {
						WebResponse.returnSuccessMsg(response, "租车成功");
					}else {
						WebResponse.returnFailureMsg(response, "数据库错误");
					}
				}else {
					WebResponse.returnFailureMsg(response, "车辆不存在或已租出");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
