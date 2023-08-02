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
public class ArticleServiceImpl extends ArticleService {
  private final JpaArticleRepository articleRepository;

  @Override
  public List<Article> articleList() {
    return articleRepository.findAll();
  }

  @Override
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

  @Override
  public List<Article> readArticle(Long articleNum) {
    return articleRepository.findAllByArticleNum(articleNum);
  }

  @Override
  public void updateArticle(Long articleNum, String title, String content) {
    Article renewArticle = articleRepository.findFirstByArticleNum(articleNum);
    renewArticle.setTitle(title);
    renewArticle.setContent(content);
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
    List<Article> searchTitleList = articleRepository.findByTitleContaining(searchParameter);
    return searchTitleList;
  }

  @Override
  @Transactional
  public List<Article> searchContent(SearchParameter searchParameter) {
    List<Article> searchContentList = articleRepository.findByContentContaining(searchParameter);
    return searchContentList;
  }

  @Override
  @Transactional
  public List<Article> searchId(SearchParameter searchParameter) {
    List<Article> searchIdList = articleRepository.findByIdContaining(searchParameter);
    return searchIdList;
  }

  @Override
  @Transactional
  public List<Article> searchAll(SearchParameter searchParameter) {
    List<Article> searchAllList = articleRepository.findByTitleOrContentOrIdContaining(searchParameter);
    return searchAllList;
  }
}
