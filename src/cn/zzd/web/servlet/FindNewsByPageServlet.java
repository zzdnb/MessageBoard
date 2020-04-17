package cn.zzd.web.servlet;

import cn.zzd.domain.News;
import cn.zzd.domain.PageBean;
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
@WebServlet("/findNewsByPageServlet")
public class FindNewsByPageServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentPage = request.getParameter("currentPage");
		String rows = request.getParameter("rows");
		if(currentPage==null||"".equals(currentPage)){
			currentPage="1";
		}
		if(rows==null||"".equals(rows)){
			rows="5";
		}
		NewsService service = new NewsServiceImpl();
		PageBean<News> pb = service.findNewsPage(currentPage, rows);
		System.out.println(pb);
		request.setAttribute("pb", pb);
        request.getRequestDispatcher("/list.jsp?username="+request.getParameter("username")).forward(request,response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
}
