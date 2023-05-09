package socialads2021;

public interface Subject {
	public abstract void notifyObservers(String news);
	public abstract void attach(Observer o);
	public abstract void detach(Observer o);

}
