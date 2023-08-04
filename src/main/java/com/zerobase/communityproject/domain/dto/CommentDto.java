package com.zerobase.communityproject.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
  private Long articleNum;
  private int commentNum;
  private String id;
  private String content;

//  @Builder
//  public CommentInfo(Long articleNum, int commentNum, String id, String content) {
//    this.articleNum = articleNum;
//    this.commentNum = commentNum;
//    this.id = id;
//    this.content = content;
//  }

//  public Comment toEntity(Article article, User user) {
//    return Comment.builder()
//        .articleNum(article)
//        .commentNum(commentNum)
//        .id(user)
//        .content(content)
//        .build();
//  }
}
