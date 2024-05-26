import com.assignment.question.FacebookSocialMediaAdapterImpl;
import com.assignment.question.SocialMediaPost;
import com.assignment.question.TwitterSocialMediaAdapterImpl;
import com.assignment.question.external.FacebookPost;
import com.assignment.question.external.TwitterApi;
import com.assignment.question.external.TwitterTweet;

import java.util.List;

public class SocialMediaManager {
    private FacebookSocialMediaAdapterImpl facebookSocialMediaAdapter = new FacebookSocialMediaAdapterImpl();
    private TwitterSocialMediaAdapterImpl twitterSocialMediaAdapter = new TwitterSocialMediaAdapterImpl();

    public void getMessages(Long userId, Long timestamp, String platform) {
        if (platform.equals("facebook")) {
            List<SocialMediaPost> posts = facebookSocialMediaAdapter.fetchPosts(userId, timestamp);
        } else if (platform.equals("twitter")) {
            List<SocialMediaPost> tweets = twitterSocialMediaAdapter.fetchPosts(userId, 1l);
        }
        // Convert the posts/tweets to a common format
    }
}