package at.edu.hti.concurrency.stores.test;

import java.util.Arrays;
import java.util.List;

import at.edu.hti.concurrency.Store;

public class RandomTest implements StoreTest {

	@Override
	public List<Integer> getTestRanges() {

		return Arrays.asList(new Integer[] { 100,10000 });
	}

	@Override
	public String getTestName() {

		return "Random";
	}

	@Override
	public long runTest(Store store, int size) {
		store.initMaxSize(size);
		long start = System.currentTimeMillis();
		for (int count = 0; count < size; count++) {
			store.addFirst("data" + count);
		}

		for (int count = size; count > 0; count--) {
			store.removeItem(count / 2);
		}

		if (store.size() > 0) {
			throw new RuntimeException("store not empty");
		}
	
		return System.currentTimeMillis() - start;

	}

	@Override
	public boolean addToResult() {

		return true;
	}

}
