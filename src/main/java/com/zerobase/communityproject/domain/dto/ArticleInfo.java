package com.zerobase.communityproject.domain.dto;

import com.zerobase.communityproject.domain.entity.Article;
import com.zerobase.communityproject.domain.entity.User;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ArticleInfo {
  private Long articleNum;
  private String id;
  private String title;
  private String content;
  private LocalDateTime regDate;

//  @Builder
//  public ArticleInfo(Long articleNum, String id, String title, String content, LocalDateTime regDate) {
//    this.articleNum = articleNum;
//    this.id = id;
//    this.title = title;
//    this.content = content;
//    this.regDate = regDate;
//  }
//
//  public Article toEntity(User user) {
//    return Article.builder()
//        .articleNum(articleNum)
//        .id(user)
//        .title(title)
//        .content(content)
//        .build();
//  }
}
