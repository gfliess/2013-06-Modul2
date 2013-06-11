package at.edu.hti.concurrency;

public interface Store {
	
	String getName();

	//Maximale Anzahl der Elemente im store
	void initMaxSize(int maxSize);

	//fuegt das Element an erster Stelle ein
	void addFirst(String data);

	//loescht Element von letzter stelle
	String removeLast();

	//loescht ein Element innerhalb des Stores
	String removeItem(int index);

	int size();


}
