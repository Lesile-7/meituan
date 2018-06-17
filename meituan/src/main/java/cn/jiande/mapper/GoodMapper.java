package cn.jiande.mapper;

import cn.jiande.pojo.Good;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface GoodMapper {
    int deleteByPrimaryKey(String id);

    int insert(Good record);

    Good selectByPrimaryKey(String id);

    List<Good> selectAll();

    int updateByPrimaryKey(Good record);
    
    List<Good> selectByParam(Good good);//多条件组合查询
}