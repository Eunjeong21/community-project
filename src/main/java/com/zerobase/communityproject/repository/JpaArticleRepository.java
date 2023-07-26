package com.zerobase.communityproject.repository;

import com.zerobase.community.domain.entity.Article;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface JpaArticleRepository extends JpaRepository<Article, Integer> {
  List<Article> findAllByArticleNum(Long articleNum);
  Article findFirstByArticleNum(Long articleNum);

  @Transactional
  void deleteArticleByArticleNum(Long articleNum);

}
