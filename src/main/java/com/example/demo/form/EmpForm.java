package com.example.demo.form;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpForm {
	//empCd空白
	@NotEmpty(message="{empCode.notEmpty}")
	//empCd数字
	@Pattern(regexp = "^[0-9]{6}$",message="{empCd.size}")
	//empCd長さ
	//@Size @Size(min=6,max=6,message="{empCd.size}")
	private String empCd;
	//name空白
    @NotEmpty(message="{empName.notEmpty}")
    // 政治表达式 正しい名前
	@Pattern(regexp = "^[一-龥 ア-ン あ-ん a-z A-Z]*$",message="{empName.error}")
	private String name;
  //birthday空白
    @NotEmpty(message="{empBirthday.notEmpty}")
	private String birthday;
    //birthday空白
	@NotEmpty(message="{nationality.notEmpty}")
	private String nationalityCd;
	//genderCd空白
	@NotEmpty(message="{empGender.notEmpty}")
	private String genderCd;
}