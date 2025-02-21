package designclass;

import java.util.*;

public class Twitter {

    private static class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    private Map<Integer, List<Tweet>> tweets;
    private Map<Integer, Set<Integer>> following;

    private int timestamp;

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);

        if (tweets.containsKey(userId)) {
            pq.addAll(tweets.get(userId));
        }

        if (following.containsKey(userId)) {
            for (int followeeID : following.get(userId)) {
                if (tweets.containsKey(followeeID)) {
                    pq.addAll(tweets.get(followeeID));
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            result.add(pq.poll().id);
            count++;
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        // User 1 posts a tweet (id = 5).
        twitter.postTweet(1, 5);

        // User 1's news feed should return a list with 1 tweet id -> [5].
        System.out.println(twitter.getNewsFeed(1)); // Output: [5]

        // User 1 follows user 2.
        twitter.follow(1, 2);

        // User 2 posts a tweet (id = 6).
        twitter.postTweet(2, 6);

        // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
        // Tweet id 6 should precede tweet id 5 because it is more recent.
        System.out.println(twitter.getNewsFeed(1)); // Output: [6, 5]

        // User 1 unfollows user 2.
        twitter.unfollow(1, 2);

        // User 1's news feed should return a list with 1 tweet id -> [5],
        // since user 1 is no longer following user 2.
        System.out.println(twitter.getNewsFeed(1)); // Output: [5]
    }
}
