package cn.jiande.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jiande.mapper.SalerMapper;
import cn.jiande.pojo.Saler;
import cn.jiande.service.SalerService;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年4月30日 下午3:56:37 
*/
@Service
public class SalerServiceImpl implements SalerService {
	
	@Autowired
	private SalerMapper dao;
	public int deleteByPrimaryKey(String id) {
		return dao.deleteByPrimaryKey(id);
	}

	public int insert(Saler record) {
		return dao.insert(record);
	}

	public Saler selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}

	public List<Saler> selectAll() {
		return dao.selectAll();
	}

	public int updateByPrimaryKey(Saler record) {
		return dao.updateByPrimaryKey(record);
	}

}
