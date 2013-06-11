/** 
 * Copyright 2013 SSI Schaefer PEEM GmbH. All Rights reserved. 
 * <br /> <br />
 * 
 * $Id$
 * <br /> <br />
 *
 */

package at.edu.hti.concurrency.prodcon;

import java.awt.image.ImageObserver;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * This is the class header. The first sentence (ending with "."+SPACE) is important, because it is
 * used summary in the package overview pages.<br />
 * <br />
 * 
 * @author ara
 * @version $Revision$
 */

public class Producer implements Runnable {

  LinkedBlockingQueue<String> queue;
  boolean isStarted = true;
  ProdConsProblem observer;

  public Producer(LinkedBlockingQueue<String> queue,ProdConsProblem observer) {
    this.queue = queue;
    this.observer = observer;
  }

  @Override
  public void run() {

    while (isStarted) {

      synchronized (queue) {
        if (observer.getNumberOfItems() > 0) {
          if (queue.remainingCapacity() > 0) {
            String s = new String("test");
            queue.add(s);
            observer.decreaseItems();

          }
        } else {
          isStarted = false;
        }
      }

    }

  }

}

//---------------------------- Revision History ----------------------------
//$Log$
//
