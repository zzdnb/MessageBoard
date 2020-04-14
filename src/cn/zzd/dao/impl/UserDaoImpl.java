package cn.zzd.dao.impl;

import cn.zzd.dao.UserDao;
import cn.zzd.domain.User;
import cn.zzd.util.JDBCUtils;

import java.sql.*;


/**
 * @author 张振东
 * @version V1.0
 * @Title:
 * @Package
 * @Description: (用一句话描述该文件做什么)
 * @date：
 */
public class UserDaoImpl implements UserDao {


	public User login(User loginUser) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from users where username = ? and password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginUser.getUsername());
			pstmt.setString(2, loginUser.getPassword());
			rs = pstmt.executeQuery();
			while (rs.next()){
				user = loginUser;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtils.close(rs, pstmt, conn);

		return user;
	}
	public int  regist(User registUser) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num=0;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "insert into users(username,password) values(?,?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, registUser.getUsername());
			pstmt.setString(2, registUser.getPassword());
			num=pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtils.close(rs, pstmt, conn);
		return num;

	}
}
