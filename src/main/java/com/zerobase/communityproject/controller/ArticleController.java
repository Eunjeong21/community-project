package com.zerobase.communityproject.controller;

import com.zerobase.communityproject.domain.dto.SearchParameter;
import com.zerobase.communityproject.domain.entity.Article;
import com.zerobase.communityproject.domain.entity.User;
import com.zerobase.communityproject.service.ArticleService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class ArticleController {
  private final ArticleService articleService;
  private final HttpSession session;

  @GetMapping("/read/article-list")
  public String readArticleList(Model model) {
    List<Article> articleList = articleService.articleList();
    model.addAttribute("list", articleList);
    return "/article-list";
  }

  @GetMapping("/create/article")
  public String createArticle() {
    User principal = (User) session.getAttribute("principal");
    if (principal == null) {
      return "redirect:/login";
    }
    return "/create-article";
  }

  @GetMapping("/read/article/{articleNum}")
  public String readArticle(Model model, @PathVariable Long articleNum) {
    model.addAttribute("article", articleService.readArticle(articleNum));
    return "/article-detail";
  }

  @GetMapping("/update/{articleNum}/updateForm")
  public String updateArticleForm(Model model, @PathVariable Long articleNum) {
    model.addAttribute("article", articleService.readArticle(articleNum));
    return "/update-article";
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
