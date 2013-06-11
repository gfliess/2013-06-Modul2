package at.edu.hti.concurrency.stores;

import java.util.LinkedList;
import java.util.List;

import at.edu.hti.concurrency.Store;

public class StoreLinkedList implements Store {

	List<String> list;

	@Override
	public String getName() {
		return "StoreLinkedList";
	}

	@Override
	public void initMaxSize(int maxSize) {
		list = new LinkedList<String>();
	}

	@Override
	public void addFirst(String data) {
		list.add(0, data);
	}

	@Override
	public String removeLast() {
		return list.remove(list.size() - 1);
	}

	@Override
	public String removeItem(int index) {
		return list.remove(index);
	}

	@Override
	public int size() {
		return list.size();
	}
}
