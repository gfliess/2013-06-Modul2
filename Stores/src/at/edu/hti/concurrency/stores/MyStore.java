package at.edu.hti.concurrency.stores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import at.edu.hti.concurrency.Store;

public class MyStore implements Store{

	private final String name="MyStore";
	private LinkedList<String> items=new LinkedList<String>();
	private int maxSize=0;
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void initMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	@Override
	public void addFirst(String data) {
		if (items.size()<maxSize)
			items.add(0,data);
	}

	@Override
	public String removeLast() {
		String itemToRemove = items.getLast();
		if (items.remove(itemToRemove))
			return itemToRemove;
		return null;
	}

	@Override
	public String removeItem(int index) {
		return items.remove(index);
	}

	@Override
	public int size() {
		return items.size();
	}

}
