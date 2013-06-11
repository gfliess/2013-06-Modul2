package at.edu.hti.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class TestMain {
	private static boolean running =true;

	public static void main(String[] args) {

		final LinkedBlockingQueue<String> elements = new LinkedBlockingQueue<>(
				2);
		
		Runnable producer = new Runnable() {

			@Override
			public void run() {
				try {
					for (int count = 0; count < 100; count++) {
						elements.put("" + count);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};
		Runnable consumer = new Runnable() {

			@Override
			public void run() {
				try {
					while (isRunning())
						System.out.println(Thread.currentThread().getName()
								+ " " + elements.poll(1, TimeUnit.SECONDS));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		// Thread t1 = new Thread(producer);
		// Thread c1 = new Thread(consumer);
		// Thread c2 = new Thread(consumer);
		//
		// t1.start();
		// c1.start();
		// c2.start();

		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		threadPool.execute(consumer);
		threadPool.execute(consumer);
		Future<?> result = threadPool.submit(producer);

		try {
			result.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		running = false;
		threadPool.shutdown();

	}

	protected static boolean isRunning() {
		
		return running ;
	}
}
