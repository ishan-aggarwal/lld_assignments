package com.assignment.question;

import java.util.List;

public interface SocialMediaAdapter {

    List<SocialMediaPost> fetchPosts(Long userId, Long timestamp);

    void postStatus(Long user, String status);

}