package com.example.demo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserForm {
       @NotEmpty (message="{login.error.accountId.notEmpty}")
       @Email(message="{login.error.accountId.isEmail}")
      private String accountId;
	  @NotEmpty(message="{login.error.password.notEmpty}")
	  //@Size(min=6,max=6,message="{login.error.password.length}")
      @Pattern(regexp = "^[0-9]{6}$",message="{userPass.error}")
      private String password;
}
