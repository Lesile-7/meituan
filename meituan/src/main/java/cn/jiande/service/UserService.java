package cn.jiande.service;

import java.util.List;

import cn.jiande.pojo.User;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年4月30日 上午10:53:51 
*/
public interface UserService {
	int deleteByPrimaryKey(String id);

    int insert(User record);

    User selectByPrimaryKey(String id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}
