package cn.zzd.dao;

import cn.zzd.domain.News;

import java.util.List;

/**
 * @author 张振东
 * @version V1.0
 * @Title:
 * @Package
 * @Description: (用一句话描述该文件做什么)
 * @date：
 */
public interface NewsDao {
	public void addNews(News news);

	List<News> finAll();

	void delNews(int id);

	String findNews(int id);

	void updateNews(News news);
}
