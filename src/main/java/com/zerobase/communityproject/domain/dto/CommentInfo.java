package com.zerobase.communityproject.domain.dto;

import com.zerobase.communityproject.domain.entity.Article;
import com.zerobase.communityproject.domain.entity.Comment;
import com.zerobase.communityproject.domain.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentInfo {
  private Long articleNum;
  private int commentNum;
  private String id;
  private String content;

  @Builder
  public CommentInfo(Long articleNum, int commentNum, String id, String content) {
    this.articleNum = articleNum;
    this.commentNum = commentNum;
    this.id = id;
    this.content = content;
  }

  public Comment toEntity(Article article, User user) {
    return Comment.builder()
        .articleNum(article)
        .commentNum(commentNum)
        .id(user)
        .content(content)
        .build();
  }
}
