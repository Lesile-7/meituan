package cn.jiande.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jiande.pojo.Order;
import cn.jiande.util.Beans.CommonQo;

@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(Order record);

    Order selectByPrimaryKey(String id);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);
    
    List<Order> selectByParam(Order order);//多条件组合查询(时间条件除外)
    
    List<Order> selectByTime(CommonQo commonQo);//根据时间区间查找订单
}