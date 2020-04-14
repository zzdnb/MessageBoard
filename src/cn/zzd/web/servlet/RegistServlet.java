package cn.zzd.web.servlet;

import cn.zzd.dao.impl.UserDaoImpl;
import cn.zzd.domain.User;
import cn.zzd.service.UserService;
import cn.zzd.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 张振东
 * @version V1.0
 * @Title:
 * @Package
 * @Description: (用一句话描述该文件做什么)
 * @date：
 */
@WebServlet("/registServlet")
public class RegistServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//设置编码
		request.setCharacterEncoding("utf-8");
		//获取请求参数
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//封装user对象
		User registUser = new User();
		registUser.setPassword(password);
		registUser.setUsername(username);
		//获取所有请求参数
		UserService userService = new UserServiceImpl();
		int result =userService.regist(registUser);
		if(result!=0){
			response.sendRedirect("regist.jsp?error=no");
		}else{
			response.sendRedirect("regist.jsp?error=yes");
		}
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
}
