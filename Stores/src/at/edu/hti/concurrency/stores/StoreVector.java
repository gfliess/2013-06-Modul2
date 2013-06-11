package at.edu.hti.concurrency.stores;

import java.util.List;
import java.util.Vector;

import at.edu.hti.concurrency.Store;

public class StoreVector implements Store {

	List<String> list;

	@Override
	public String getName() {
		return "StoreVector";
	}

	@Override
	public void initMaxSize(int maxSize) {
		list = new Vector<String>(maxSize);
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
