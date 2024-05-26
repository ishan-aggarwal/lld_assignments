package com.assignment.question;

import com.assignment.question.external.*;

import java.util.*;

public class FacebookSocialMediaAdapterImpl implements SocialMediaAdapter {

    private FacebookApi facebookApi = new FacebookApi();

    public List<SocialMediaPost> fetchPosts(Long userId, Long timestamp) {
        List<FacebookPost> facebookPosts = facebookApi.fetchFacebookPosts(userId, timestamp);
        return convertToSocialMediaPosts(facebookPosts);
    }

    private static List<SocialMediaPost> convertToSocialMediaPosts(List<FacebookPost> facebookPosts) {
        List<SocialMediaPost> socialMediaPosts = new ArrayList<>();
        for (FacebookPost facebookPost : facebookPosts) {
            SocialMediaPost socialMediaPost = new SocialMediaPost();
            socialMediaPost.setId(facebookPost.getId());
            socialMediaPost.setStatus(facebookPost.getStatus());
            socialMediaPost.setUserId(facebookPost.getUserId());
            socialMediaPost.setTimestamp(facebookPost.getTimestamp());
            socialMediaPosts.add(socialMediaPost);
        }
        return socialMediaPosts;
    }

    public void postStatus(Long user, String status) {
        facebookApi.postFacebookStatus(user, status);
    }
}
