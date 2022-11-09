package mini.Tweet;

import java.util.ArrayList;

public abstract class UserManager {
    protected String userID;

    public abstract void add(UserManager userManager);

    public abstract ArrayList<UserManager> getMembers();

    public abstract void accept(Visitor v);

    public String getID() {
        return userID;
    }

    @Override
    public String toString() {
        return userID;
    }
}
