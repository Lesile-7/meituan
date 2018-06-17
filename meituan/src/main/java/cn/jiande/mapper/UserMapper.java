package cn.jiande.mapper;

import cn.jiande.pojo.User;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    User selectByPrimaryKey(String id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
    
    List<User> selectByParam(User user);//多条件这和查询
}