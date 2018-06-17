package cn.jiande.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jiande.mapper.OrderMapper;
import cn.jiande.pojo.Order;
import cn.jiande.service.OrderService;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年4月30日 下午3:41:28 
*/
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper dao;
	public int deleteByPrimaryKey(String id) {
		return dao.deleteByPrimaryKey(id);
	}

	public int insert(Order record) {
		return dao.insert(record);
	}

	public Order selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}

	public List<Order> selectAll() {
		return dao.selectAll();
	}

	public int updateByPrimaryKey(Order record) {
		return dao.updateByPrimaryKey(record);
	}

}
