package cn.jiande.mapper;

import cn.jiande.pojo.Shoppingcart;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingcartMapper {
    int deleteByPrimaryKey(String id);

    int insert(Shoppingcart record);

    Shoppingcart selectByPrimaryKey(String id);

    List<Shoppingcart> selectAll();

    int updateByPrimaryKey(Shoppingcart record);
    
    List<Shoppingcart> selectByParam(Shoppingcart shoppingcart);//多条件这和查询
}