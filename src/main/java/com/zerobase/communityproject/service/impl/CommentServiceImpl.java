package com.zerobase.communityproject.service.impl;

import com.zerobase.communityproject.domain.dto.CommentDto;
import com.zerobase.communityproject.domain.dto.CommentUpdateDto;
import com.zerobase.communityproject.domain.entity.Article;
import com.zerobase.communityproject.domain.entity.Comment;
import com.zerobase.communityproject.domain.entity.User;
import com.zerobase.communityproject.repository.JpaArticleRepository;
import com.zerobase.communityproject.repository.JpaCommentRepository;
import com.zerobase.communityproject.repository.JpaUserRepository;
import com.zerobase.communityproject.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
  private final JpaArticleRepository articleRepository;
  private final JpaUserRepository userRepository;
  private final JpaCommentRepository commentRepository;

  @Override
  @Transactional
  public void createComment(CommentDto commentDto) {
    Article article = articleRepository.findFirstByArticleNum(commentDto.getArticleNum());
    User user = userRepository.findById(commentDto.getId()).orElseThrow(() -> new IllegalArgumentException(""));
    Comment comment = Comment.builder()
        .id(user)
        .articleNum(article)
        .content(commentDto.getContent())
        .build();
    commentRepository.save(comment);
  }

  @Override
  @Transactional
  public void updateComment(CommentUpdateDto commentUpdateDto) {
    Article article = articleRepository.findFirstByArticleNum(commentUpdateDto.getArticleNum());
    User user = userRepository.findById(commentUpdateDto.getId()).orElseThrow(() -> new IllegalArgumentException(""));
    Comment comment = Comment.builder()
        .id(user)
        .articleNum(article)
        .content(commentUpdateDto.getContent())
        .build();
    commentRepository.save(comment);
  }

  @Override
  @Transactional
  public void deleteComment(int commentNum) {
    commentRepository.deleteCommentByCommentNum(commentNum);
  }
}
