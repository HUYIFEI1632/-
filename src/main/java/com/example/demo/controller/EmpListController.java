package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.bean.EmpData;
import com.example.demo.service.EmpService;
import com.example.demo.service.ExcelService;
//控制器注入
@Controller
//
@ComponentScan({"service"})
public class EmpListController {
	@Autowired
	//实装类UserService 的注入
	 private EmpService empService;
	@GetMapping("/empList")
 	 public String empList(Model model) {	
		//serviceList.listEmpメソッドの返却値
		ArrayList<EmpData> empList =empService.listEmp();
		//社員情報一覧画面のmodelに入れる
		model.addAttribute("emplist",empList);
		session.setAttribute("emplist", empList);
 		 return "empList";
    }
	@PostMapping("/searchEmp")
	//keyWord 关键字检索 社员信息
	public String listEmp(@RequestParam(value="keyWord")String keyWord, Model model) {	
		
		List<EmpData> empList=empService.searchEmp(keyWord);
		//検索情報を遷移
		model.addAttribute("emplist",empList);
		session.setAttribute("emplist", empList);
		return "empList";
	}
	//社員詳細情報に遷移
	@GetMapping("/showDetails")
	public String showDatails(@RequestParam(value="empCd")String empCd,Model model) {
		//社員詳細情報取得
		EmpData empData=empService.getEmpData(empCd);
		model.addAttribute("emp",empData);
		return "empDatails";
	}
	@Autowired
    private ExcelService excelService;
	@Autowired
	HttpSession session;
	@GetMapping("/u_denpyouExcel")
	// ページから渡したのリスポンス
	public void empDataExcel(HttpServletResponse response) throws IOException {
		// 初期化shouhinList、一覧画面のリストを使う
		@SuppressWarnings("unchecked")
		List<EmpData> empData =  (List<EmpData>) session.getAttribute("emplist");
		// エクセルを生成する
		excelService.empDataExcel(response, empData);
	} 
}

