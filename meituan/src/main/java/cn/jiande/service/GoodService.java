package cn.jiande.service;

import java.util.List;

import cn.jiande.pojo.Good;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年4月30日 上午10:50:52 
*/
public interface GoodService {
	int deleteByPrimaryKey(String id);

    int insert(Good record);

    Good selectByPrimaryKey(String id);

    List<Good> selectAll();

    int updateByPrimaryKey(Good record);
}
