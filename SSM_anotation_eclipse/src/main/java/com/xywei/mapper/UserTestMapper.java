package com.xywei.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xywei.domain.User;

public interface UserTestMapper {

	@Select("select * from t_user where username=#{username} and passwd = #{password}")
	User findUser(@Param("username") String username, @Param("password") String password);
}
