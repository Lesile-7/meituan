package cn.jiande.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jiande.mapper.GoodMapper;
import cn.jiande.pojo.Good;
import cn.jiande.service.GoodService;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年4月30日 下午3:36:46 
*/
@Service
public class GoodServiceImpl implements GoodService {
	@Autowired
	private GoodMapper dao;
	
	public int deleteByPrimaryKey(String id) {
		return dao.deleteByPrimaryKey(id);
	}

	public int insert(Good record) {
		return dao.insert(record);
	}

	public Good selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}

	public List<Good> selectAll() {
		return dao.selectAll();
	}

	public int updateByPrimaryKey(Good record) {
		return dao.updateByPrimaryKey(record);
	}

}
