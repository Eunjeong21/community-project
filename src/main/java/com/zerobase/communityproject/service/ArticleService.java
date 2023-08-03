package com.zerobase.communityproject.service;

import com.zerobase.communityproject.domain.dto.SearchParameter;
import com.zerobase.communityproject.domain.entity.Article;
import com.zerobase.communityproject.domain.entity.User;
import java.util.List;

public interface ArticleService {
  List<Article> articleList();
  void createArticle(Article article, User user);
  Article readArticle(Long articleNum);
  void updateArticle(Long articleNum, Article article);
  void deleteArticle(Long articleNum);
  List<Article> searchTitle(SearchParameter searchParameter);
  List<Article> searchContent(SearchParameter searchParameter);
  List<Article> searchId(SearchParameter searchParameter);
  List<Article> searchAll(SearchParameter searchParameter);
}
