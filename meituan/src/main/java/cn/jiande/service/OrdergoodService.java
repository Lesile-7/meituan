package cn.jiande.service;

import java.util.List;

import cn.jiande.pojo.Ordergood;

/**
 * @author longjie
 * @mail httpsession@qq.com
 * @date 2018年4月30日 下午3:30:00
 */
public interface OrdergoodService {
	int deleteByPrimaryKey(String id);

	int insert(Ordergood record);

	Ordergood selectByPrimaryKey(String id);

	List<Ordergood> selectAll();

	int updateByPrimaryKey(Ordergood record);
}
