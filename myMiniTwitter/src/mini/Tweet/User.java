package mini.Tweet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class User extends UserManager implements Subject {
    private static HashMap<String, User> users = new HashMap<String, User>();
    private ArrayList<Observer> followers;
    private ArrayList<String> following;
    private ArrayList<String> tweets;
    private NewsFeed newsFeed;
    private String group;

    // Constructor
    public User(String id, String group) {
        if (!users.containsKey(id)) {
            this.userID = id;
            this.followers = new ArrayList<Observer>();
            this.following = new ArrayList<String>();
            this.tweets = new ArrayList<String>();
            this.group = group;
            this.newsFeed = new NewsFeed();
            this.register(newsFeed);
            users.put(id, this);
        } else {
            System.out.println("This Id already exists....");
        }
    }// end Constructor

    // ----------Extended Methods----------
    @Override
    public void add(UserManager um) {
        System.out.println("Cannot add....");
    }

    @Override
    public ArrayList<UserManager> getMembers() {
        return null;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
    // ----------End Extended Methods----------

    // ----------Implemented Methods----------
    @Override
    public void register(Observer obj) {
        if (obj == null) {
            System.out.println("Null observer");
        }
        if (!followers.contains(obj)) {
            followers.add(obj);
        }
    }

    @Override
    public Object getUpdate(Observer obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void notifyObs() {
        for (Observer obs : followers) {
            obs.update(tweets.get(tweets.size() - 1), this);
        }
    }
    // ----------End Implemented Methods----------

    // -----------Default Methods-----------
    // Some default methods are managed by the UserManager Class
    public NewsFeed getFeed() {
        return newsFeed;
    }

    public ArrayList<Observer> getFollowers() {
        return followers;
    }

    public String getGroup() {
        return group;
    }

    public ArrayList<String> getTweets() {
        return tweets;
    }

    public ArrayList<String> getFollowing() {
        return following;
    }

    public void setFollowers(ArrayList<Observer> followers) {
        this.followers = followers;
    }

    public void setFollowing(ArrayList<String> following) {
        this.following = following;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setNewsFeed(NewsFeed newsFeed) {
        this.newsFeed = newsFeed;
    }

    public void setTweets(ArrayList<String> tweets) {
        this.tweets = tweets;
    }

    public static void setUsers(HashMap<String, User> users) {
        User.users = users;
    }
    // -----------End Default Methods-----------

    public Collection getUsers() {
        return users.values();
    }

    public static boolean exists(String uid) {
        return users.containsKey(uid);
    }

    public void follow(String id) {
        users.get(id).register(newsFeed);
        following.add(id);
        for (String s : users.get(id).getTweets()) {
            newsFeed.update(s, users.get(id));
        }
    }

    public void joinGroup(String id) {
        group = id;
    }

    public void tweet(String msg) {
        tweets.add(msg);
        notifyObs();
    }

    public boolean isFollowing(String id) {
        return following.contains(id);
    }

}
