
/** 
 * Copyright 2013 SSI Schaefer PEEM GmbH. All Rights reserved. 
 * <br /> <br />
 * 
 * $Id$
 * <br /> <br />
 *
 */

package at.edu.hti.concurrency.prodcon;

import java.util.concurrent.LinkedBlockingQueue;


/**
 * This is the class header. The first sentence (ending with "."+SPACE) is important,
 * because it is used summary in the package overview pages.<br />
 * <br />
 *
 *
 * @author  ara
 * @version $Revision$
 */

public class Consumer implements Runnable {

  LinkedBlockingQueue<String> queue;
  boolean isStarted=true;
  ProdConsProblem observer;

  public Consumer(LinkedBlockingQueue<String> queue,ProdConsProblem observer) {
    this.queue=queue;
    this.observer=observer;
    
  }
  @Override
  public void run() {
    
    while(isStarted){
      
      synchronized (queue) {
        
        if(!queue.isEmpty()){
          queue.remove();
        }
        else{
          if(observer.getNumberOfItems()==0){
            isStarted=false;
          }
        }
      }
      
      
    }

  }

}


//---------------------------- Revision History ----------------------------
//$Log$
//
