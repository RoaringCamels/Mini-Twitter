package mini.Tweet;

public interface Visitor {
    public void visit(User user);

    public void visit(UserGroup userGroup);
}
