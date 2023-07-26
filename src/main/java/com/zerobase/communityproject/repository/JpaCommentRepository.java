package com.zerobase.communityproject.repository;

import com.zerobase.community.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface JpaCommentRepository extends JpaRepository<Comment, Integer> {
  Comment findByCommentNum(int commentNum);
  @Transactional
  void deleteCommentByCommentNum(int CommentNum);

}
