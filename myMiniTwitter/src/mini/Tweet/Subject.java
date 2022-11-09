package mini.Tweet;

public interface Subject {
    public void register(Observer obj);

    public void notifyObs();

    public Object getUpdate(Observer obj);
}
