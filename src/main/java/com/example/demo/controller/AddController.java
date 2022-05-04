package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.bean.EmpData;
import com.example.demo.bean.Gender;
import com.example.demo.bean.Nationality;
import com.example.demo.form.EmpForm;
import com.example.demo.service.EmpService;
import com.example.demo.service.GenderService;
import com.example.demo.service.NationalityService;

@Controller
public class AddController {

	@Autowired
	public GenderService genderService;
	@Autowired
	public NationalityService nationalityService;
	@Autowired
	public  EmpService empService;
	@Autowired
	public MessageSource messageSource;
	@Autowired
	HttpSession session;
	//新規登録画面に遷移
    @GetMapping(value="/toAddEmp")
   public String toAddEmp(@ModelAttribute("form")EmpForm form,Model model) {
    	//Genderデータ取得
      	ArrayList<Gender> genderList=genderService.listGender();
      	//Genderデータsessionに導入
        session.setAttribute("genderList",genderList);
        //Nationalityデータ取得
    	ArrayList<Nationality> nationalityList=nationalityService.listNationality();
    	//Nationalityデータsessionに導入
    	session.setAttribute("nationalityList",nationalityList);
		return "addEmp";
	}
    
    @PostMapping("/addEmp")
	public String addEmp(@ModelAttribute("form")@Valid EmpForm empForm,BindingResult result,Model model,Locale locale) {
    	String url;
    	//errorがあるかどうか判断
		if(result.hasErrors()) {
	    //error
		List<ObjectError> errorList=result.getAllErrors();
		//errorデータ画面に導入
		model.addAttribute("errorList",errorList);
		url="addEmp";
      }else {
    	  //errorないとき
    	  EmpData empData=empService.getEmpData(empForm.getEmpCd());
    	  //入力empData空白
    	  if(empData!=null) {
    		  //
    		model.addAttribute("message",messageSource.getMessage("addEmp.error", null, locale));
    		 url="addEmp";
    	  }else {
    		  //正しい情報を登録
    		  empService.insertEmp(empForm);
    		  url="redirect:/empList";
    	  }
      }
		return url;
	}

}

