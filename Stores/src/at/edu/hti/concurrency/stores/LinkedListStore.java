package at.edu.hti.concurrency.stores;

import java.util.LinkedList;

import at.edu.hti.concurrency.Store;

public class LinkedListStore implements Store {
	
	LinkedList<String> store = new LinkedList<String>();
	int maxSize = 0;

	@Override
	public String getName() {
		return "LinkedListStore";
	}

	@Override
	public void initMaxSize(int maxSize) {
		store = new LinkedList<String>();
		this.maxSize = maxSize;
	}

	@Override
	public void addFirst(String data) {
		if (store.size() < this.maxSize) {
			store.addFirst(data);
			return;
		}
		throw new ArrayIndexOutOfBoundsException("Store exeeds size "+maxSize);
	}

	@Override
	public String removeLast() {
		return store.removeLast();
	}

	@Override
	public String removeItem(int index) {
		return store.remove(index);
	}

	@Override
	public int size() {
		return store.size();
	}

}
