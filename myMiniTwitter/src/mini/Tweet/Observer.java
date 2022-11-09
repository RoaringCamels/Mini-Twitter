package mini.Tweet;

public interface Observer {
    public void update(String message, Subject subject);
}
