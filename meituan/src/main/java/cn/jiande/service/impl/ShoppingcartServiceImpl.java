package cn.jiande.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jiande.mapper.ShoppingcartMapper;
import cn.jiande.pojo.Shoppingcart;
import cn.jiande.service.ShoppingcartService;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年4月30日 下午6:03:00 
*/
@Service
public class ShoppingcartServiceImpl implements ShoppingcartService {
	
	@Autowired
	private ShoppingcartMapper dao;
	
	public int deleteByPrimaryKey(String id) {
		return dao.deleteByPrimaryKey(id);
	}

	public int insert(Shoppingcart record) {
		return dao.insert(record);
	}

	public Shoppingcart selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}

	public List<Shoppingcart> selectAll() {
		return dao.selectAll();
	}

	public int updateByPrimaryKey(Shoppingcart record) {
		return dao.updateByPrimaryKey(record);
	}

}
