package com.zerobase.communityproject.service;

import com.zerobase.communityproject.domain.dto.UserInput;
import com.zerobase.communityproject.domain.entity.User;
import com.zerobase.communityproject.repository.JpaUserRepository;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
  private final JpaUserRepository userRepository;
  public void createAccount(UserInput userInput) {
    User user = User.builder()
        .id(userInput.getId())
        .email(userInput.getEmail())
        .password(userInput.getPassword())
        .birth(userInput.getBirth())
        .address1(userInput.getAddress1())
        .address2(userInput.getAddress2())
        .regDate(LocalDate.now())
        .build();
    userRepository.save(user);
  }

}
