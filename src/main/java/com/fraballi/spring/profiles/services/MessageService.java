package com.fraballi.spring.profiles.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fraballi.spring.profiles.config.ProfilesConfiguration;
import com.fraballi.spring.profiles.domain.Message;

/**
 * @author Felix Aballi <felixaballi@gmail.com>
 */
@Service
public class MessageService {

   private final ProfilesConfiguration configuration;

   @Autowired
   public MessageService(ProfilesConfiguration configuration) {
      this.configuration = configuration;
   }

   public Message getMessage() {
      return Message
            .builder()
            .application(configuration.getApplicationName())
            .profiles(configuration.getActiveProfiles())
            .message(configuration.getMessage())
            .build();
   }
}
