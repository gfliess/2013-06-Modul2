package at.edu.hti.concurrency.stores.test;

import java.util.List;

import at.edu.hti.concurrency.Store;

public interface StoreTest {

	public List<Integer> getTestRanges();
	public String getTestName();
	public long runTest(Store store, int size);
	public boolean addToResult();
	
}
