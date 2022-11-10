package mini.Tweet;

public interface Subject {
    public void register(Observer observer);

    public void notifyObs();

    public Object getUpdate(Observer observer);
}
