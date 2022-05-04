package com.example.demo.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;


@org.springframework.web.bind.annotation.ControllerAdvice
@Component
public class ControllerAdvice {
	@ExceptionHandler(DataAccessException.class)
	public String DataAccessExceptionHandler(DataAccessException e,Model model) {
		model.addAttribute("error","内部エラー");
		model.addAttribute("message","DataAccessExceptionが発生しました");
		model.addAttribute("status",HttpStatus.INTERNAL_SERVER_ERROR);
		return "error";
		
	}

}
