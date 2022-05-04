package com.example.demo.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.bean.Gender;
@Mapper
public interface GenderMapper {

	 public ArrayList<Gender> listGender();
}
