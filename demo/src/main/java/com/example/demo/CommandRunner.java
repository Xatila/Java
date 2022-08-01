package com.example.demo;

import models.Account;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import services.AccountService;
import services.UserService;

import java.math.BigDecimal;

@Component
public class CommandRunner implements CommandLineRunner {

    @Autowired
    public UserService userService;
    //private final AccountService accountService;

  //  public CommandRunner(UserService userService, AccountService accountService) {
      //  this.userService = userService;
       // this.accountService = accountService;
  //  }

    @Override
    public void run(String... args) throws Exception {


        User user = new User("kevin", 19);
        this.userService.registerUser(user);


    }
}
