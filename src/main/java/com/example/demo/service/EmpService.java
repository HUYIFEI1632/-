package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.bean.EmpData;
import com.example.demo.form.EmpForm;

public interface EmpService {
        //listEmp方法EmpDataデータ情報を取る
	    public ArrayList<EmpData> listEmp();
	  //searchEmp方法キーワード検索EmpDataデータ情報を取る
        public List<EmpData> searchEmp(String keyWord);
      //getEmpData方法名前link社員詳細情報を取る
        public EmpData getEmpData(String empCd);
      //insertEmp方法社員情報登録
        public void insertEmp(EmpForm empForm);
        public void changeEmp(EmpForm empForm);
        public void deleteEmp(String empCd);
}
