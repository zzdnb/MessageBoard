package cn.zzd.dao;

import cn.zzd.domain.User;

/**
 * @author 张振东
 * @version V1.0
 * @Title:
 * @Package
 * @Description: (用一句话描述该文件做什么)
 * @date：
 */
public interface UserDao {
	public User login(User loginUser);
	public int  regist(User registUser);


}
