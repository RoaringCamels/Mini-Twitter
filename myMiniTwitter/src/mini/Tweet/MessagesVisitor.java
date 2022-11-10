package mini.Tweet;

import javax.swing.JOptionPane;

public class MessagesVisitor implements Visitor {

    @Override
    public void visit(User user) {
        int total = 0;
        for (Object temp : user.getUsers()) {
            User followingUser = (User) temp;
            total += followingUser.getTweets().size();
        }
        JOptionPane.showMessageDialog(null, "Total tweets: " + total);
    }

    @Override
    public void visit(UserGroup userGroup) {
        throw new UnsupportedOperationException();
    }

}
