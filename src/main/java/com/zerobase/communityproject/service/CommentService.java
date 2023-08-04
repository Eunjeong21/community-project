package com.zerobase.communityproject.service;

import com.zerobase.communityproject.domain.dto.CommentDto;
import com.zerobase.communityproject.domain.dto.CommentUpdateDto;

public interface CommentService {
  void createComment(CommentDto commentDto);
  void updateComment(CommentUpdateDto commentUpdateDto);
  void deleteComment(int CommentNum);
}
