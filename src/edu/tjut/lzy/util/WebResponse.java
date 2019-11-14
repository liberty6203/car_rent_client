package edu.tjut.lzy.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class WebResponse {
	
	public static boolean returnSuccessMsg(HttpServletResponse response,String msg) {
		boolean r = false;
		response.setContentType("text/html;charset=utf-8");
		String resp = "{\"status\":"+1+",\"msg\":\""+msg+"\"}";
		try {
			response.getWriter().write(resp);
			r = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	public static boolean returnFailureMsg(HttpServletResponse response,String msg) {
		boolean r = false;
		response.setContentType("text/html;charset=utf-8");
		String resp = "{\"status\":"+0+",\"msg\":\""+msg+"\"}";
		try {
			response.getWriter().write(resp);
			r = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return r;
	}
	
}
