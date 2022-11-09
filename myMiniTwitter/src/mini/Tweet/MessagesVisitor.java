package mini.Tweet;

import javax.swing.JOptionPane;

public class MessagesVisitor implements Visitor {

    @Override
    public void visit(User u) {
        int total = 0;
        for (Object o : u.getUsers()) {
            User us = (User) o;
            total += us.getTweets().size();
        }
        JOptionPane.showMessageDialog(null, "Total tweets: " + total);
    }

    @Override
    public void visit(UserGroup ug) {
        throw new UnsupportedOperationException();
    }

}
