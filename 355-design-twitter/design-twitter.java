class Twitter {

    class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    HashMap<Integer, HashSet<Integer>> followMap;

    HashMap<Integer, List<Tweet>> tweetMap;

    int time;

    public Twitter() {

        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {

        tweetMap.putIfAbsent(userId, new ArrayList<>());

        tweetMap.get(userId).add(new Tweet(tweetId, time));

        time++;
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> pq =
            new PriorityQueue<>(
                (a, b) -> b.time - a.time
            );

        if (tweetMap.containsKey(userId)) {

            for (Tweet t : tweetMap.get(userId)) {
                pq.offer(t);
            }
        }

        if (followMap.containsKey(userId)) {

            for (int followee : followMap.get(userId)) {

                if (tweetMap.containsKey(followee)) {

                    for (Tweet t : tweetMap.get(followee)) {
                        pq.offer(t);
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();

        int count = 0;

        while (!pq.isEmpty() && count < 10) {

            res.add(pq.poll().id);

            count++;
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {

        followMap.putIfAbsent(
            followerId,
            new HashSet<>()
        );

        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (followMap.containsKey(followerId)) {

            followMap.get(followerId).remove(followeeId);
        }
    }
}