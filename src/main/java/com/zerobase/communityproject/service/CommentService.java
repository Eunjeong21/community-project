package com.zerobase.communityproject.service;

import com.zerobase.community.domain.entity.Article;
import com.zerobase.community.domain.entity.Comment;
import com.zerobase.community.domain.entity.User;
import com.zerobase.community.repository.JpaArticleRepository;
import com.zerobase.community.repository.JpaCommentRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {
  private final JpaArticleRepository articleRepository;
  private final JpaCommentRepository commentRepository;

  public void createComment(Article articleNum, int commentNum, User id, String content) {
    Comment newComment = Comment.builder()
        .articleNum(articleNum)
        .commentNum(commentNum)
        .id(id)
        .content(content)
        .regDate(LocalDateTime.now())
        .build();
    commentRepository.save(newComment);
  }

  //articleNum 추가
  public void updateComment(Long articleNum, int commentNum, String content) {
    Comment renewComment = commentRepository.findByCommentNum(commentNum);
    renewComment.setContent(content);
    renewComment.setUpdateDate(LocalDateTime.now());
  }

  public void deleteComment(int commentNum) {
    commentRepository.deleteCommentByCommentNum(commentNum);
  }
}
