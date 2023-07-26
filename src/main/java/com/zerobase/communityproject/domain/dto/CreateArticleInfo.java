package com.zerobase.communityproject.domain.dto;

import com.zerobase.communityproject.domain.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateArticleInfo {
  private Long articleNum;
  private User id;
  private String title;
  private String content;

}
