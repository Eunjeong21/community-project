package com.zerobase.communityproject.service;

import com.zerobase.communityproject.domain.dto.UserInput;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
  boolean createAccount(UserInput userInput);


}
