package at.edu.hti.concurrency.stores;

import java.util.Vector;

import at.edu.hti.concurrency.Store;

public class VectorStore implements Store {
	
	Vector<String> store = new Vector<String>();

	@Override
	public String getName() {
		return "VectorStore";
	}

	@Override
	public void initMaxSize(int maxSize) {
		store = new Vector<String>(maxSize);
	}

	@Override
	public void addFirst(String data) {
		store.add(0, data);
	}

	@Override
	public String removeLast() {
		return store.remove(store.size());
	}

	@Override
	public String removeItem(int index) {
		return store.remove(store.size());
	}

	@Override
	public int size() {
		return store.size();
	}

}
