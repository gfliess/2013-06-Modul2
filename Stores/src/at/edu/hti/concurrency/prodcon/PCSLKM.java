
package at.edu.hti.concurrency.prodcon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;

public class PCSLKM implements ProducerConsumerStarter {

  private static final class Producer implements Runnable {
    private LinkedBlockingQueue<String> q = null;
    private String message;

    /**
     * @param q
     */
    public Producer(LinkedBlockingQueue<String> q, String message) {
      this.q = q;
      this.message = message;
    }

    /** {@inheritDoc} */
    @Override
    public void run() {
      try {
        q.put(message);
      } catch (InterruptedException e) {
        //FIXME
        e.printStackTrace();
      }
    }
  }

  private static final class Consumer implements Runnable {

    private LinkedBlockingQueue<String> q;

    /**
     * @param q
     */
    public Consumer(LinkedBlockingQueue<String> q) {
      this.q = q;
    }

    /** {@inheritDoc} */
    @Override
    public void run() {
      while (true) {
        try {
          System.out.println(Thread.currentThread().getId() + ": " + q.take());
        } catch (InterruptedException e) {
          //FIXME
          e.printStackTrace();
        }
      }
    }

  }

  private LinkedBlockingQueue<String> q;
  private ExecutorService producers = null;
  private ExecutorService consumers = null;
  private long numberOfEvents;

  /** {@inheritDoc} */
  @Override
  public long runProducerConsumerTest() {
    long start = System.nanoTime();
    while (numberOfEvents-- > 0) {
      producers.execute(new Producer(q, "message-" + numberOfEvents));
      consumers.execute(new Consumer(q));
    }
    return System.nanoTime() - start;
  }

  /** {@inheritDoc} */
  @Override
  public void setUpTest(Configuration configuration) {
    if (configuration == null) {
      throw new NullPointerException("'configuration' must not be null");
    }

    q = new LinkedBlockingQueue<>(configuration.getBufferSize());
    numberOfEvents = configuration.getNumberOfItems();

    producers = Executors.newFixedThreadPool(configuration.getNumberOfProcuders(), new ThreadFactory() {
      @Override
      public Thread newThread(Runnable r) {
        return new Thread(r, "Producer");
      }
    });

    consumers = Executors.newFixedThreadPool(configuration.getNumberOfProcuders(), new ThreadFactory() {
      @Override
      public Thread newThread(Runnable r) {
        return new Thread(r, "Consumer");
      }
    });

  }

}

//---------------------------- Revision History ----------------------------
//$Log$
//
