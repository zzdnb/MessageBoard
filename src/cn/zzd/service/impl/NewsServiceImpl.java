package cn.zzd.service.impl;

import cn.zzd.dao.NewsDao;
import cn.zzd.dao.impl.NewsDaoImpl;
import cn.zzd.domain.News;
import cn.zzd.service.NewsService;

import java.util.List;

/**
 * @author 张振东
 * @version V1.0
 * @Title:
 * @Package
 * @Description: (用一句话描述该文件做什么)
 * @date：
 */
public class NewsServiceImpl implements NewsService {
	NewsDao newsDao = new NewsDaoImpl();
	@Override
	public void addNews(News news) {
		newsDao.addNews(news);
	}

	@Override
	public List<News> findall() {
		return newsDao.finAll();
	}

	@Override
	public void delNews(int id) {
		newsDao.delNews(id);
	}

	@Override
	public String findNews(int id) {
		return newsDao.findNews(id);
	}

	@Override
	public void updateNews(News news) {
		newsDao.updateNews( news);
	}
}
