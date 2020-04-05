package com.fraballi.spring.profiles.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import com.fraballi.spring.profiles.services.MessageService;
import com.google.gson.Gson;

import lombok.extern.log4j.Log4j2;

/**
 * @author Felix Aballi <felixaballi@gmail.com>
 */
@Log4j2
public class MessageRunner implements ApplicationRunner {

   private final MessageService service;

   @Autowired
   public MessageRunner(MessageService service) {
      this.service = service;
   }

   @Override
   public void run(ApplicationArguments args) {
      final Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
      final String output = gson.toJson(service.getMessage());
      log.info("\n\n[Environment] \n {}\t\t", output);
   }
}
