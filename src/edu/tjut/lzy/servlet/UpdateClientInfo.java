package edu.tjut.lzy.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.tjut.lzy.dao.DBUtil;
import edu.tjut.lzy.util.WebResponse;

/**
 * Servlet implementation class UpdateClientInfo
 */
@WebServlet("/UpdateClientInfo")
public class UpdateClientInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone = request.getParameter("phone");
		String name =  new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8");
		String idcard = request.getParameter("idcard");
		String sex = new String(request.getParameter("sex").getBytes("iso-8859-1"), "utf-8");
		String passwoed = request.getParameter("password");
		String sql = "select * from client where phone='"+phone+"'";
		ResultSet rSet = DBUtil.execQuery(sql);
		try {
			if (rSet.next()) {
				String updatesql = "update client set ";
				updatesql = updatesql+"name = '"+name+"',";
				updatesql = updatesql+"idcard='"+idcard+"',";
				updatesql = updatesql+"sex='"+sex+"',";
				updatesql = updatesql+"password='"+passwoed+"'";
				updatesql = updatesql+"where phone='"+phone+"'";
				System.out.println(updatesql);
				int isUpdate = DBUtil.execUpdate(updatesql);
				if (isUpdate>0) {
					WebResponse.returnSuccessMsg(response, "修改成功");
				}else {
					WebResponse.returnFailureMsg(response, "修改失败");
				}
			}else {
				WebResponse.returnFailureMsg(response, "用户不存在");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
