package cn.jiande.service;

import java.util.List;

import cn.jiande.pojo.Order;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年4月30日 上午10:52:53 
*/
public interface OrderService {
	int deleteByPrimaryKey(String id);

    int insert(Order record);

    Order selectByPrimaryKey(String id);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);
}
