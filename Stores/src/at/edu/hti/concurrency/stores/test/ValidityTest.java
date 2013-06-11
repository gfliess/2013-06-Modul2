package at.edu.hti.concurrency.stores.test;

import java.util.Arrays;
import java.util.List;

import at.edu.hti.concurrency.Store;

public class ValidityTest implements StoreTest {

	@Override
	public List<Integer> getTestRanges() {

		return Arrays.asList(new Integer[] { 5 });
	}

	@Override
	public String getTestName() {

		return "Validity";
	}

	@Override
	public long runTest(Store store, int size) {
		store.initMaxSize(size);

		store.addFirst("1");
		store.addFirst("2");
		store.addFirst("3");
		store.addFirst("4");
		store.addFirst("5");

		if (!"1".equals(store.removeLast()))
			throw new IllegalStateException("Illegal return value");
		if (!"5".equals(store.removeItem(0)))
			throw new IllegalStateException("Illegal return value");
		if (!"2".equals(store.removeItem(2)))
			throw new IllegalStateException("Illegal return value");
		if (!"3".equals(store.removeLast()))
			throw new IllegalStateException("Illegal return value");
		if (!"4".equals(store.removeLast()))
			throw new IllegalStateException("Illegal return value");

		if (store.size() != 0)
			throw new IllegalStateException("Store not empty");
		return 0;
	}

	@Override
	public boolean addToResult() {

		return false;
	}

}
