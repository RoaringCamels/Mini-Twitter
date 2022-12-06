package mini.Tweet;

import javax.swing.JOptionPane;

public class IDVisitor implements Visitor {

    @Override
    public void visit(User user) {
        JOptionPane.showMessageDialog(null, "All IDs are unique: " + user.checkID(user));

    }

    @Override
    public void visit(UserGroup userGroup) {
        throw new UnsupportedOperationException();

    }

}
