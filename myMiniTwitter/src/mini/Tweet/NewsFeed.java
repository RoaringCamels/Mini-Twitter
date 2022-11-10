package mini.Tweet;

import java.util.ArrayList;

public class NewsFeed implements Observer, Subject {
    ArrayList<String> feed;
    ArrayList<Observer> followers;

    // Constructor
    public NewsFeed() {
        feed = new ArrayList<String>();
        followers = new ArrayList<Observer>();
    }
    // end Constructor

    // ---------- Observer Implementation----------
    @Override
    public void update(String msg, Subject sub) {
        User u = (User) sub;
        feed.add(u.getID() + ": " + msg);
        notifyObs();
    }
    // ---------- End Observer Implementation----------

    // ----------Subject Implementation----------
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
    public void notifyObs() {
        for (Observer ob : followers) {
            ob.update(null, this);
        }
    }

    @Override
    public Object getUpdate(Observer obj) {
        throw new UnsupportedOperationException();
    }
    // ----------End Subject Implementation----------

    // ----------Default Methods----------
    public ArrayList<String> getFeed() {
        return feed;
    }
    // ----------End Default Methods----------

}
