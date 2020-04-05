package com.fraballi.spring.profiles.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fraballi.spring.profiles.domain.Message;
import com.fraballi.spring.profiles.services.MessageService;

/**
 * @author Felix Aballi <felixaballi@gmail.com>
 */
@RestController
@RequestMapping(value = "/message")
public class MessageController {

   private final MessageService service;

   @Autowired
   public MessageController(MessageService service) {
      this.service = service;
   }

   @GetMapping
   public Message get() {
      return service.getMessage();
   }
}
