package cn.zzd.service;

import cn.zzd.domain.News;
import cn.zzd.domain.User;

import java.util.List;

/**
 * @author 张振东
 * @version V1.0
 * @Title:
 * @Package
 * @Description: (用一句话描述该文件做什么)
 * @date：
 */
public interface UserService {
	public User login(User loginUser);
	public int  regist(User registUser);



}
