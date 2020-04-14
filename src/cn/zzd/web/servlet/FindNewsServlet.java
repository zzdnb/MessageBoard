package cn.zzd.web.servlet;


import cn.zzd.service.NewsService;
import cn.zzd.service.impl.NewsServiceImpl;

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
@WebServlet("/findNewsServlet")
public class FindNewsServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		NewsService newsService = new NewsServiceImpl();
		request.setAttribute("content",newsService.findNews(id));
		request.getRequestDispatcher("/update.jsp?username="+request.getParameter("username")).forward(request,response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
}
