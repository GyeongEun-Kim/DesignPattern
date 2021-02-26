package observerPattern;

public interface Subject {

	public void addObserver(Observer addob);

	public void removeObserver(Observer rmob);

	public void notifyObservers();

}