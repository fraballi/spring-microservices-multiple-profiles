package com.fraballi.spring.profiles.config;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.validation.annotation.Validated;

import com.fraballi.spring.profiles.runners.MessageRunner;
import com.fraballi.spring.profiles.services.MessageService;

import lombok.Data;

/**
 * @author Felix Aballi <felixaballi@gmail.com>
 */
@Validated
@Data
@Configuration
public class ProfilesConfiguration {

   private ConfigurableEnvironment env;

   @Value(value = "${spring.application.name}")
   private String applicationName;

   @NotBlank
   @Value(value = "${custom.message:no-message}")
   private String message;

   @Autowired
   public ProfilesConfiguration(ConfigurableEnvironment env) {
      this.env = env;
   }

   public String[] getActiveProfiles() {
      return env.getActiveProfiles();
   }

   @Bean
   public MessageRunner messageRunner(MessageService service) {
      return new MessageRunner(service);
   }
}