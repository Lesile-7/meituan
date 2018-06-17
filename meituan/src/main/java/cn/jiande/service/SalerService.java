package cn.jiande.service;

import java.util.List;

import cn.jiande.pojo.Saler;

/**
 * @author longjie
 * @mail httpsession@qq.com
 * @date 2018年4月30日 上午10:53:18
 */
public interface SalerService {
	int deleteByPrimaryKey(String id);

	int insert(Saler record);

	Saler selectByPrimaryKey(String id);

	List<Saler> selectAll();

	int updateByPrimaryKey(Saler record);
}
