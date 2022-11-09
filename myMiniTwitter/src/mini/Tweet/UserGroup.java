package mini.Tweet;

import java.util.ArrayList;
import java.util.HashMap;

public class UserGroup extends UserManager {
    private ArrayList<UserManager> members;
    public static HashMap<String, UserGroup> groups = new HashMap<String, UserGroup>();

    // Constructor
    public UserGroup(String id) {
        members = new ArrayList<UserManager>();
        this.userID = id;
        groups.put(id, this);
    }
    // end constructor

    // ----------Extended Methods----------
    @Override
    public void add(UserManager um) {
        if (um.getMembers() == null)
            members.add((User) um);
        else
            members.add((UserGroup) um);
    }

    public ArrayList<UserManager> getMembers() {
        return members;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    // ----------End Extended Methods----------

    public static boolean exists(String userID) {
        return groups.containsKey(userID);
    }

    public static UserGroup findGroup(String newGroup) {
        return groups.get(newGroup);
    }

}
