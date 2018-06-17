package cn.jiande.service;

import java.util.List;

import cn.jiande.pojo.Shoppingcart;

/**
 * @author longjie
 * @mail httpsession@qq.com
 * @date 2018年4月30日 下午3:30:36
 */
public interface ShoppingcartService {
	int deleteByPrimaryKey(String id);

	int insert(Shoppingcart record);

	Shoppingcart selectByPrimaryKey(String id);

	List<Shoppingcart> selectAll();

	int updateByPrimaryKey(Shoppingcart record);
	
	 List<Shoppingcart> selectByParam(Shoppingcart shoppingcart);//多条件这和查询
}
