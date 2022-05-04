package com.example.demo.bean;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpData {
   private String empCd;
   private String name;
   private Date birthday;
   private Nationality nationality;
   private Gender gender;
}
