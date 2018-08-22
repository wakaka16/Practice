package com.wxl.springbootredis.reponsitory;

import com.wxl.springbootredis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserRepository {

    @Select("select * from t_user where name = #{userName}")
    User findByUserName(@Param(value = "userName") String userName);
}
