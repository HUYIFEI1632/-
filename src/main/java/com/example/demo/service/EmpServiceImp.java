package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.EmpData;
import com.example.demo.form.EmpForm;
import com.example.demo.mapper.EmpMapper;
@Service
public class EmpServiceImp implements EmpService{
	//注入 empMapper
	@Autowired
	private EmpMapper empMapper;
	@Override
	public ArrayList<EmpData> listEmp() {
		//empMapper中のlistEmp方法 リスポンスを得る
		return  empMapper.listEmp();
	}
	@Override
	public List<EmpData> searchEmp(String keyWord){
		//empMapperなかのsearchEmp方法 リスポンスを得る
		return  empMapper.searchEmp("%"+keyWord+"%");	
	}
	@Override
	public EmpData getEmpData(String empCd) {
		//empMapper中getEmpData方法 リスポンスを得る
	return  empMapper.getEmpData(empCd);
	}
	@Override
	public void insertEmp(EmpForm empForm) {
		empMapper.insertEmp(empForm);
	}
	@Override
	public void changeEmp(EmpForm empForm) {
		empMapper.changeEmp(empForm);
		
	}
	@Override
	public void deleteEmp (String empCd) {
		empMapper.deleteEmp(empCd);
	}
	
}
