package com.zerobase.communityproject.service.impl;

import com.zerobase.communityproject.domain.dto.UserInput;
import com.zerobase.communityproject.domain.entity.User;
import com.zerobase.communityproject.repository.JpaUserRepository;
import com.zerobase.communityproject.service.UserService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
  private final JpaUserRepository userRepository;

  @Override
  public boolean createAccount(UserInput userInput) {
    Optional<User> optionalUser = userRepository.findById(userInput.getId());
    if (optionalUser.isPresent()) {
      return false;
    }
    String encodingPassword = BCrypt.hashpw(userInput.getPassword(), BCrypt.gensalt());

    User user = User.builder()
        .id(userInput.getId())
        .email(userInput.getEmail())
        .password(encodingPassword)
        .birth(userInput.getBirth())
        .address1(userInput.getAddress1())
        .address2(userInput.getAddress2())
        .regDate(LocalDate.now())
        .build();
    userRepository.save(user);
    return true;
  }

  @Override
  public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
    Optional<User> optionalId = userRepository.findById(id);
    if (!optionalId.isPresent()) {
      throw new UsernameNotFoundException("회원정보가 존재하지 않습니다.");
    }
    User user = optionalId.get();
    List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
    grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
    return new org.springframework.security.core.userdetails.User(user.getId(), user.getPassword(), grantedAuthorities);
  }
}
