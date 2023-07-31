package com.zerobase.communityproject.controller;

import com.zerobase.communityproject.domain.dto.UserInput;
import com.zerobase.communityproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
  private final UserService userService;

  @GetMapping("/user/register")
  public String register() {
    return "/user-register";
  }

  @PostMapping("/user/register")
  public String registerSubmit(Model model, UserInput userInput) {
    boolean result = userService.createAccount(userInput);
    model.addAttribute("result", result);
    return "/user-register-complete";
  }

  @RequestMapping("/user/login")
  public String login() {
    return "/login";
  }

}
