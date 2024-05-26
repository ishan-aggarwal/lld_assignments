package com.assignment.question;

import com.assignment.question.external.*;

import java.util.*;

public class TwitterSocialMediaAdapterImpl implements SocialMediaAdapter {
    private TwitterApi twitterApi = new TwitterApi();

    public List<SocialMediaPost> fetchPosts(Long userId, Long timestamp) {
        List<TwitterTweet> tweets = twitterApi.getTweets(userId);
        return convertToSocialMediaPosts(tweets);
    }

    private static List<SocialMediaPost> convertToSocialMediaPosts(List<TwitterTweet> tweets) {
        List<SocialMediaPost> socialMediaPosts = new ArrayList<>();
        for (TwitterTweet tweet : tweets) {
            SocialMediaPost socialMediaPost = new SocialMediaPost();
            socialMediaPost.setId(tweet.getId());
            socialMediaPost.setStatus(tweet.getTweet());
            socialMediaPost.setUserId(tweet.getUserId());
            socialMediaPosts.add(socialMediaPost);
        }
        return socialMediaPosts;
    }

    public void postStatus(Long user, String text) {
        twitterApi.tweet(user, text);
    }
}