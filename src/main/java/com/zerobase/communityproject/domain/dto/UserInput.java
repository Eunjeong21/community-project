package com.zerobase.communityproject.domain.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInput {
  private String id;
  private String email;
  private String password;
  private String name;
  private LocalDate birth;
  private String address1;
  private String address2;
}
