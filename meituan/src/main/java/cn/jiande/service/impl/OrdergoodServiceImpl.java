package cn.jiande.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jiande.mapper.OrdergoodMapper;
import cn.jiande.pojo.Ordergood;
import cn.jiande.service.OrdergoodService;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年4月30日 下午3:39:19 
*/
@Service
public class OrdergoodServiceImpl implements OrdergoodService {

	@Autowired
	private OrdergoodMapper dao;

	public int deleteByPrimaryKey(String id) {
		return dao.deleteByPrimaryKey(id);
	}

	public int insert(Ordergood record) {
		return dao.insert(record);
	}

	public Ordergood selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}

	public List<Ordergood> selectAll() {
		return dao.selectAll();
	}

	public int updateByPrimaryKey(Ordergood record) {
		return dao.updateByPrimaryKey(record);
	}

}
