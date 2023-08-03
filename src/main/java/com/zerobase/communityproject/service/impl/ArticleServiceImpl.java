package com.zerobase.communityproject.service.impl;

import com.zerobase.communityproject.domain.dto.SearchParameter;
import com.zerobase.communityproject.domain.entity.Article;
import com.zerobase.communityproject.domain.entity.User;
import com.zerobase.communityproject.repository.JpaArticleRepository;
import com.zerobase.communityproject.service.ArticleService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService {
  private final JpaArticleRepository articleRepository;

  @Override
  public List<Article> articleList() {
    return articleRepository.findAll();
  }

  @Override
  @Transactional
  public void createArticle(Article article, User user) {
    article.setId(user);
    articleRepository.save(article);
  }

  @Override
  @Transactional(readOnly = true)
  public Article readArticle(Long articleNum) {
    return articleRepository.findFirstByArticleNum(articleNum);
  }

  @Override
  public void updateArticle(Long articleNum, Article article) {
    Article renewArticle = articleRepository.findFirstByArticleNum(articleNum);
    renewArticle.setTitle(article.getTitle());
    renewArticle.setContent(article.getContent());
    renewArticle.setUpdateDate(LocalDateTime.now());
    articleRepository.save(renewArticle);
  }

  @Override
  public void deleteArticle(Long articleNum) {
    articleRepository.deleteArticleByArticleNum(articleNum);
  }

  @Override
  @Transactional
  public List<Article> searchTitle(SearchParameter searchParameter) {
    return articleRepository.findByTitleContaining(searchParameter);
  }

  @Override
  @Transactional
  public List<Article> searchContent(SearchParameter searchParameter) {
    return articleRepository.findByContentContaining(searchParameter);
  }

  @Override
  @Transactional
  public List<Article> searchId(SearchParameter searchParameter) {
    return articleRepository.findByIdContaining(searchParameter);
  }

  @Override
  @Transactional
  public List<Article> searchAll(SearchParameter searchParameter) {
    return articleRepository.findByTitleOrContentOrIdContaining(searchParameter);
  }
}
