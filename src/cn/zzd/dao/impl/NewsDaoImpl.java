package cn.zzd.dao.impl;

import cn.zzd.dao.NewsDao;
import cn.zzd.domain.News;

import cn.zzd.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;

import java.util.List;

/**
 * @author 张振东
 * @version V1.0
 * @Title:
 * @Package
 * @Description: (用一句话描述该文件做什么)
 * @date：
 */
public class NewsDaoImpl implements NewsDao {
	@Override
	public void addNews(News news) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "insert into news(username,content) values(?,?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, news.getUsername());
			pstmt.setString(2, news.getContent());
			num = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtils.close(rs, pstmt, conn);

	}

	@Override
	public List<News> finAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<News> list = new ArrayList<>();
		News news = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from news ";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				news = new News();
				news.setId(rs.getInt(1));
				news.setUsername(rs.getString(2));
				news.setContent(rs.getString(3));
				list.add(news);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtils.close(rs, stmt, conn);

		return list;
	}

	@Override
	public void delNews(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "delete from news where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			System.out.println(pstmt.execute());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtils.close(pstmt, conn);


	}

	@Override
	public String findNews(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String msg = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select content from news where id=?  ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				msg = rs.getString("content");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtils.close(rs, pstmt, conn);
		return msg;
	}

	@Override
	public void updateNews(News news) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String msg = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "update news set content=? where id=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, news.getContent());
			pstmt.setInt(2, news.getId());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtils.close(rs, pstmt, conn);

	}

	@Override
	public int findTotalCount() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select count(*)from news  ";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtils.close(rs,stmt, conn);
		return count;
	}


	@Override
	public List<News> findByPage(int start, int rows) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<News> list = new ArrayList<>();
		News news = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from news limit ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,start);
			pstmt.setInt(2,rows);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				news = new News();
				news.setId(rs.getInt(1));
				news.setUsername(rs.getString(2));
				news.setContent(rs.getString(3));
				list.add(news);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtils.close(rs, pstmt, conn);

		return list;
	}
}
