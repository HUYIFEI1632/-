package com.example.demo.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.bean.Nationality;

@Mapper
public interface NationalityMapper {
	 public ArrayList<Nationality> listNationality();
}
