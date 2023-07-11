package leetcode.heap;

import java.util.*;

public class Twitter {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
    }
    private Map<Integer, List<Integer[]>> userTweetMap;
    private Map<Integer, Set<Integer>> followersMap;
    private int time = 0;
    public Twitter() {
        userTweetMap = new HashMap<>();
        followersMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userTweetMap.computeIfAbsent(userId, key -> new ArrayList<>());
        userTweetMap.get(userId).add(new Integer[]{tweetId, time++});
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>(10);
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((tweet1, tweet2) -> -Integer.compare(tweet1[1], tweet2[1]));
        Set<Integer> followers = followersMap.getOrDefault(userId, new HashSet<>());
        for (int followerId : followers) {
            pq.addAll(userTweetMap.getOrDefault(followerId, new ArrayList<>()));
        }
        if (!followers.contains(userId)) {
            pq.addAll(userTweetMap.getOrDefault(userId, new ArrayList<>()));
        }
        for (int i = 0; i < 10; i++) {
            if (!pq.isEmpty()) result.add(pq.remove()[0]);
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        followersMap.computeIfAbsent(followerId, key -> new HashSet<>());
        followersMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followers = followersMap.get(followerId);
        if (followers != null) {
            followers.remove(followeeId);
        }
    }
}
