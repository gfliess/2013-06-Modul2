package at.edu.hti.concurrency;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import at.edu.hti.concurrency.stores.test.RandomTest;
import at.edu.hti.concurrency.stores.test.SequentiellTest;
import at.edu.hti.concurrency.stores.test.StoreTest;
import at.edu.hti.concurrency.stores.test.ValidityTest;
import at.edu.hti.concurrency.util.InstanceUtil;

public class StoretestApp {

	public static void main(String[] args) throws Exception {

		StoreTest[] tests = new StoreTest[] { new ValidityTest(),
				new SequentiellTest(), new RandomTest() };
		StringBuilder builder = new StringBuilder();
		generateCSVHeader(tests, builder);

		List<Store> stores = InstanceUtil.returnAvailableStoreImplementations();
		for (Store store : stores) {
			builder.append(store.getName() + ";");
			runTests(store, tests, builder);
			builder.append("\n");
		}

		System.out.println(builder);

		FileWriter test1Csv = new FileWriter("test1.csv");
		test1Csv.append(builder);
		test1Csv.close();
	}

	private static void generateCSVHeader(StoreTest[] tests,
			StringBuilder builder) {
		builder.append("Store;");
		for (StoreTest storeTest : tests) {
			if (storeTest.addToResult()) {
				for (int size : storeTest.getTestRanges()) {
					builder.append(storeTest.getTestName() + "-" + size + ";");
				}
			}
		}
		builder.append("\n");
	}

	private static void runTests(Store store, StoreTest[] tests,
			StringBuilder builder) {

		for (StoreTest storeTest : tests) {
		
			System.err.print("Running: " + storeTest.getTestName() + " on "
					+ store.getName());

			for (int size : storeTest.getTestRanges()) {
				System.err.print(" " + size);
				try {
					long runTest = storeTest.runTest(store, size);
					if (storeTest.addToResult())
						builder.append(runTest + ";");
				} catch (Throwable t) {
					t.printStackTrace();
					if (storeTest.addToResult())
						builder.append("-1 ;");
				}
			}
			System.err.println();

		}
	}

	protected static void printHeaderLine(int[] synTestValues,
			int[] ranTestValues, Appendable builder) throws IOException {

		builder.append("Store;");
		for (int i : synTestValues) {
			builder.append("syn " + i + ";");
		}
		for (int i : ranTestValues) {
			builder.append("ran " + i + ";");
		}
		builder.append("\n");
	}

	private static long testSeq(Store store, int i) {
		store.initMaxSize(i);
		long start = System.currentTimeMillis();
		for (int count = 0; count < i; count++) {
			store.addFirst("data" + count);
		}

		for (int count = 0; count < i; count++) {
			store.removeLast();
		}

		if (store.size() > 0) {
			throw new RuntimeException("store not empty");
		}

		return System.currentTimeMillis() - start;

	}

	private static long testRna(Store store, int i) {
		store.initMaxSize(i);
		long start = System.currentTimeMillis();
		for (int count = 0; count < i; count++) {
			store.addFirst("data" + count);
		}

		for (int count = i; count > 0; count--) {
			store.removeItem(count / 2);
		}

		if (store.size() > 0) {
			throw new RuntimeException("store not empty");
		}

		return System.currentTimeMillis() - start;

	}
}
