package com.zerobase.communityproject.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="article")
public class Article {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "article_num")
  private Long articleNum;
  private String title;
  private String content;
  @Column(name = "reg_date")
  private LocalDateTime regDate;
  @Column(name = "update_date")
  private LocalDateTime updateDate;
  @Column(name = "delete_date")
  private LocalDateTime deleteDate;

  @ManyToOne
  @JoinColumn(name = "id")
  private User id;

  @OneToMany(mappedBy = "article")
  private List<Comment> comments;
}
