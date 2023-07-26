package com.zerobase.communityproject.service;

import com.zerobase.community.domain.entity.Article;
import com.zerobase.community.domain.entity.User;
import com.zerobase.community.repository.JpaArticleRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArticleService {
  private final JpaArticleRepository articleRepository;

  public void createArticle(Long articleNum, User id, String title, String content) {
    Article newArticle = Article.builder()
        .articleNum(articleNum)
        .id(id)
        .title(title)
        .content(content)
        .regDate(LocalDateTime.now())
        .build();
    articleRepository.save(newArticle);
  }

  public List<Article> readArticle(Long articleNum) {
    return articleRepository.findAllByArticleNum(articleNum);
  }

  public void updateArticle(Long articleNum, String title, String content) {
    Article renewArticle = articleRepository.findFirstByArticleNum(articleNum);
    renewArticle.setTitle(title);
    renewArticle.setContent(content);
    renewArticle.setUpdateDate(LocalDateTime.now());
    articleRepository.save(renewArticle);
  }

  public void deleteArticle(Long articleNum) {
    articleRepository.deleteArticleByArticleNum(articleNum);
  }
}
