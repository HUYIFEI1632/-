package com.example.demo.logincontroller;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.UserForm;
import com.example.demo.service.UserServiceImp;
//控制器注入
@Controller
//
@ComponentScan({"service"})
public class LoginController {
	@Resource
	//实装类UserServiceImp 的注入
	   private UserServiceImp userServiceImp ;
	@Autowired
	HttpSession session;
	@GetMapping("/login")
	//与前端链接 获取前端请求 
     public String login(@ModelAttribute("form")UserForm form,Model model){
    	 return "login";
     }
	@PostMapping("/auth")
	// 获取前端数据 与数据库进行错误判断 并返回错误信息提示
	public String auth(@ModelAttribute("form")@Valid UserForm userForm,BindingResult relust,Model model,Locale locale) {
		String url=null;
		if(relust.hasErrors()) {
			// ObjectError 是错误信息 的数据类型 下面是固定用法
			List<ObjectError>errorList=relust.getAllErrors();
			model.addAttribute("errorList",errorList);
			url="login";
			return url;
		}
		// 请求信息的长度 不为0  返回错误信息
		List<String> errorList=userServiceImp.getResult(userForm, locale);
		if(!(errorList.size()==0)){
			model.addAttribute("message",errorList.get(0));
			url="login";
			return url;
			}else {
				//画面迁移 rediret 新的请求页面
			session.setAttribute("accountId", userForm.getAccountId());
			session.setMaxInactiveInterval(300);
			url="redirect:/empList";
			return url;
			}
		
	}
}
