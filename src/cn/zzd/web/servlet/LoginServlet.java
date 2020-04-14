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
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码
		req.setCharacterEncoding("utf-8");
		//获取请求参数
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		//封装user对象
		User loginUser = new User();
		loginUser.setPassword(password);
		loginUser.setUsername(username);
		//获取所有请求参数
		UserService userService = new UserServiceImpl();
		User user =userService.login(loginUser);
		if(user==null){
			//登录失败
			resp.sendRedirect("login.jsp?error=yes");
		}else{
			//登录成功
			//存储数据
			req.setAttribute("username",username);
			req.getRequestDispatcher("/newsListServlet?username="+username).forward(req,resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req,resp);
	}
}
