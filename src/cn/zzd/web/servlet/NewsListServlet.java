package cn.zzd.web.servlet;

import cn.zzd.domain.News;
import cn.zzd.service.NewsService;

import cn.zzd.service.impl.NewsServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 张振东
 * @version V1.0
 * @Title:
 * @Package
 * @Description: (用一句话描述该文件做什么)
 * @date：
 */
@WebServlet("/newsListServlet")
public class NewsListServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewsService service = new NewsServiceImpl();
		List<News> news = service.findall();
		request.setAttribute("news", news);
		//System.out.println(request.getParameter("username"));
		if ("1813004745".equals(request.getParameter("username"))||request.getParameter("username")==null) {
			request.getRequestDispatcher("/list2.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/list.jsp?username=" + request.getParameter("username")).forward(request, response);

		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
}
