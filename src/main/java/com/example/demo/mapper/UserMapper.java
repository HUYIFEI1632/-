package com.example.demo.mapper;
import org.apache.ibatis.annotations.Mapper;

import com.example.demo.bean.LoginUser;
@Mapper
public interface UserMapper {
	//find方法获取数据库信息
public LoginUser find(String accountId);
}