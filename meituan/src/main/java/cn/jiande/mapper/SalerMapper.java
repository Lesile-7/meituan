package cn.jiande.mapper;

import cn.jiande.pojo.Saler;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface SalerMapper {
    int deleteByPrimaryKey(String id);

    int insert(Saler record);

    Saler selectByPrimaryKey(String id);

    List<Saler> selectAll();

    int updateByPrimaryKey(Saler record);
    
    List<Saler> selectByParam(Saler saler);//多条件这和查询
}