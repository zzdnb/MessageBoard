package cn.zzd.test;

import cn.zzd.dao.impl.NewsDaoImpl;
import cn.zzd.domain.News;
import cn.zzd.service.impl.NewsServiceImpl;
import cn.zzd.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


/**
 * @author 张振东
 * @version V1.0
 * @Title:
 * @Package
 * @Description: (用一句话描述该文件做什么)
 * @date：
 */
public class JdbcDemo3 {
	@Test
	public void test() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test2() {
		List<News> list = new NewsDaoImpl().finAll();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	@Test
	public void test3() {
		new NewsDaoImpl().delNews(34);
	}

	@Test
	public void test4() {
		System.out.println(new NewsDaoImpl().findNews(1));
	}
	@Test
	public void test5(){
		System.out.println(new NewsDaoImpl().findTotalCount());
	}
	@Test
	public void test6(){
		System.out.println(new NewsDaoImpl().findByPage(0,5));
	}
	@Test
	public void test7(){
		System.out.println(new NewsServiceImpl().findNewsPage("1","3"));
	}
}
