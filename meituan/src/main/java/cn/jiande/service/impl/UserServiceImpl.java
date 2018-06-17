package cn.jiande.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jiande.mapper.UserMapper;
import cn.jiande.pojo.User;
import cn.jiande.service.UserService;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年4月30日 下午6:09:46 
*/
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper dao;
	
	public int deleteByPrimaryKey(String id) {
		return dao.deleteByPrimaryKey(id);
	}

	public int insert(User record) {
		return dao.insert(record);
	}

	public User selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}

	public List<User> selectAll() {
		return dao.selectAll();
	}

	public int updateByPrimaryKey(User record) {
		return dao.updateByPrimaryKey(record);
	}

}
