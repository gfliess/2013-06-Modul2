package at.edu.hti.concurrency.stores;

import java.util.ArrayList;

import at.edu.hti.concurrency.Store;

public class SimpleList implements Store {

	ArrayList<String> list = new ArrayList<>();

	@Override
	public String getName() {

		return "Gerhard Test";
	}

	@Override
	public void initMaxSize(int maxSize) {
		list = new ArrayList<>(maxSize);
	}

	@Override
	public void addFirst(String data) {
		list.add(0, data);

	}

	@Override
	public String removeLast() {
		
		return list.remove(list.size()-1);
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
