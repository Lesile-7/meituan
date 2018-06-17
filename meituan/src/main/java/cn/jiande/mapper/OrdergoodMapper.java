package cn.jiande.mapper;

import cn.jiande.pojo.Ordergood;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface OrdergoodMapper {
    int deleteByPrimaryKey(String id);

    int insert(Ordergood record);

    Ordergood selectByPrimaryKey(String id);

    List<Ordergood> selectAll();

    int updateByPrimaryKey(Ordergood record);
    
    List<Ordergood> selectByParam(Ordergood ordergood);//多条件这和查询
}