package com.zerobase.communityproject.controller;

import com.zerobase.communityproject.domain.dto.SearchParameter;
import com.zerobase.communityproject.domain.entity.Article;
import com.zerobase.communityproject.domain.entity.User;
import com.zerobase.communityproject.service.impl.ArticleServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ArticleController {
  private final ArticleServiceImpl articleService;

  @GetMapping("/read/article-list")
  public String readArticleList(Model model) {
    List<Article> articleList = articleService.articleList();
    model.addAttribute("list", articleList);
    return "/article-list";
  }

  @PostMapping("create/article")
  void createArticle(@RequestBody Long articleNum, User id, String title, String content) {
    articleService.createArticle(articleNum, id, title, content);
  }

  @GetMapping("/read/article")
  List<Article> readArticle(Long articleNum) {
    return articleService.readArticle(articleNum);
  }

  @PutMapping("/update/article/{articleNum}")
  void updateArticle(@PathVariable Long articleNum, String title, String content) {
    articleService.updateArticle(articleNum, title, content);
  }

  @DeleteMapping("/delete/article/{articleNum}")
  void deleteArticle(@PathVariable Long articleNum) {
    articleService.deleteArticle(articleNum);
  }

  @GetMapping("/read/search/title")
  public String searchTitle(SearchParameter searchParameter, Model model) {
    List<Article> searchTitleList = articleService.searchTitle(searchParameter);
    model.addAttribute("searchTitleList", searchTitleList);
    return "/article-list";
  }

  @GetMapping("/read/search/content")
  public String searchContent(SearchParameter searchParameter, Model model) {
    List<Article> searchContentList = articleService.searchContent(searchParameter);
    model.addAttribute("searchContentList", searchContentList);
    return "/article-list";
  }

  @GetMapping("/read/search/id")
  public String searchId(SearchParameter searchParameter, Model model) {
    List<Article> searchIdList = articleService.searchId(searchParameter);
    model.addAttribute("searchIdList", searchIdList);
    return "/article-list";
  }

  @GetMapping("/read/search/all")
  public String searchAll(SearchParameter searchParameter, Model model) {
    List<Article> searchAllList = articleService.searchAll(searchParameter);
    model.addAttribute("searchAllList", searchAllList);
    return "/article-list";
  }
}
