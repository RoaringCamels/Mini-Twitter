package mini.Tweet;

import javax.swing.JOptionPane;

public class UserVisitor implements Visitor {

    @Override
    public void visit(User user) {
        JOptionPane.showMessageDialog(null, "Total amount of Users: " + user.getUsers().size());
    }

    @Override
    public void visit(UserGroup userGroup) {
        throw new UnsupportedOperationException();
    }

}
