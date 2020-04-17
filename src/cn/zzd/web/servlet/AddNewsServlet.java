package cn.zzd.web.servlet;

import cn.zzd.domain.News;
import cn.zzd.service.NewsService;
import cn.zzd.service.UserService;
import cn.zzd.service.impl.NewsServiceImpl;
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
@WebServlet("/addNewsServlet")
public class AddNewsServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String content = request.getParameter("content");
		News news = new News();
		news.setUsername(username);
		news.setContent(content);
		NewsService Service = new NewsServiceImpl();
		Service.addNews(news);
		System.out.println(username);
		request.getRequestDispatcher( "/findNewsByPageServlet?username="+username).forward(request,response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
}
