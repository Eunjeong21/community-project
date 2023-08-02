package com.zerobase.communityproject.repository;

import com.zerobase.communityproject.domain.dto.SearchParameter;
import com.zerobase.communityproject.domain.entity.Article;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface JpaArticleRepository extends JpaRepository<Article, Integer> {
  List<Article> findAllByArticleNum(Long articleNum);
  Article findFirstByArticleNum(Long articleNum);
  List<Article> findByTitleContaining(SearchParameter searchParameter);
  List<Article> findByContentContaining(SearchParameter searchParameter);
  List<Article> findByIdContaining(SearchParameter searchParameter);
  List<Article> findByTitleOrContentOrIdContaining(SearchParameter searchParameter);


  @Transactional
  void deleteArticleByArticleNum(Long articleNum);


}
