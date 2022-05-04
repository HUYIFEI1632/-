package com.example.demo.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class MessageConfig {
	 // 用验证规则做的一个设定（messageSource） 与 UserServiceImpZ中的messageSource 一致
		@Autowired
		private MessageSource messageSource;
		
		@Bean
		public LocalValidatorFactoryBean validator() {
			LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
			
			localValidatorFactoryBean.setValidationMessageSource(messageSource);
			
			return localValidatorFactoryBean;
		}

}
