package com.zerobase.communityproject.controller;

import com.zerobase.community.domain.dto.UserInput;
import com.zerobase.community.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
  private final UserService userService;

  @GetMapping("/user/register")
  public String register() {
    return "";
  }

  @PostMapping("/user/register")
  void registerSubmit(@RequestBody UserInput userInput) {
    userService.createAccount(userInput);
  }

  @GetMapping("/user/login")
  public String login() {
    return "";
  }

}
