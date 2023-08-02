package com.zerobase.communityproject.service.impl;

import com.zerobase.communityproject.domain.entity.Article;
import com.zerobase.communityproject.domain.entity.Comment;
import com.zerobase.communityproject.domain.entity.User;
import com.zerobase.communityproject.repository.JpaArticleRepository;
import com.zerobase.communityproject.repository.JpaCommentRepository;
import com.zerobase.communityproject.service.CommentService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
  private final JpaArticleRepository articleRepository;
  private final JpaCommentRepository commentRepository;

  @Override
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
  @Override
  public void updateComment(Long articleNum, int commentNum, String content) {
    Comment renewComment = commentRepository.findByCommentNum(commentNum);
    renewComment.setContent(content);
    renewComment.setUpdateDate(LocalDateTime.now());
  }

  @Override
  public void deleteComment(int commentNum) {
    commentRepository.deleteCommentByCommentNum(commentNum);
  }
}
