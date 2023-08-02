package com.zerobase.communityproject.service;

import com.zerobase.communityproject.domain.dto.SearchParameter;
import com.zerobase.communityproject.domain.entity.Article;
import java.util.List;

public interface ArticleService {
  List<Article> articleList();
  void createArticle();
  List<Article> readArticle();
  void updateArticle();
  void deleteArticle();
  List<Article> searchTitle(SearchParameter searchParameter);
  List<Article> searchContent(SearchParameter searchParameter);
  List<Article> searchId(SearchParameter searchParameter);
  List<Article> searchAll(SearchParameter searchParameter);
}
