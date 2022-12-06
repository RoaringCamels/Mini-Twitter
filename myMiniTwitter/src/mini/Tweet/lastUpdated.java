package mini.Tweet;

import javax.swing.JOptionPane;

public class lastUpdated implements Visitor {

    @Override
    public void visit(User user) {
        JOptionPane.showMessageDialog(null, "Most recently updated user: " + user.getUniqueID());

    }

    @Override
    public void visit(UserGroup userGroup) {
        throw new UnsupportedOperationException();

    }
}
