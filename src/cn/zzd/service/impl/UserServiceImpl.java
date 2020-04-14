package cn.zzd.service.impl;

import cn.zzd.dao.UserDao;
import cn.zzd.dao.impl.UserDaoImpl;
import cn.zzd.domain.User;
import cn.zzd.service.UserService;

/**
 * @author 张振东
 * @version V1.0
 * @Title:
 * @Package
 * @Description: (用一句话描述该文件做什么)
 * @date：
 */
public class UserServiceImpl implements UserService {
	UserDao userDao= new UserDaoImpl();
	@Override
	public User login(User loginUser) {
		return userDao.login(loginUser);
	}

	@Override
	public int regist(User registUser) {
		return userDao.regist(registUser);
	}


}
