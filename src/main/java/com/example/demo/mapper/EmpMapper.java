package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.bean.EmpData;
import com.example.demo.form.EmpForm;
@Mapper
public interface EmpMapper {
	public ArrayList<EmpData> listEmp();
	public List<EmpData> searchEmp(String keyWord);
	public EmpData getEmpData(String empCd);
	//データベースupData insertEmpと接続
	public void insertEmp(EmpForm empForm);
	public void changeEmp(EmpForm empForm);
	 public void deleteEmp(String empCd);
}
