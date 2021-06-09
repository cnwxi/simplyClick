package com.wxi.simplyclick.service;

import org.springframework.stereotype.Service;

@Service
public interface AdminCommentService {
    // 删除用户评论
    boolean delComment(String username, int filmId);

    // 屏蔽用户评论内容，修改content为“此评论已被屏蔽”
    boolean banComment(String username, int filmId, Float score);
}
