package mini.Tweet;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;

public class UserGroup extends UserManager {
    private ArrayList<UserManager> members;
    public static HashMap<String, UserGroup> groups = new HashMap<String, UserGroup>();
    private String groupUniqueID;
    private long groupCreationTime;

    // Constructor
    public UserGroup(String id) {
        members = new ArrayList<UserManager>();
        this.userID = id;
        this.groupUniqueID = randomIDGenerator(10);
        System.out.println(groupUniqueID);

        this.groupCreationTime = System.currentTimeMillis();
        System.out.println(groupCreationTime);
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

    /**
     * This method creates the student ID randomly picked from a default set String
     * called
     * notSoRandom
     * 
     * @param lengthOfID integer that defines the length of the String to be
     *                   returned
     * @return Randomly generated ID of type String
     */
    private String randomIDGenerator(int lengthOfID) {
        String notSoRandom = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder s = new StringBuilder(lengthOfID);

        int i;
        for (i = 0; i < lengthOfID; i++) {
            int ch = (int) (notSoRandom.length() * Math.random()); // generates a random number using Math.random()
            s.append(notSoRandom.charAt(ch)); // adds a random character one by one at the end of s
        }
        return s.toString();
    }// end IDGenerator
}
