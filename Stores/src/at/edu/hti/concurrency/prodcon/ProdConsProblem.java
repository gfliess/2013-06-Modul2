
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

public class ProdConsProblem implements ProducerConsumerStarter {

  
  LinkedBlockingQueue<String> queue;
  Configuration configuration;
   int numberOfItems;
  @Override
  public void setUpTest(Configuration configuration) {
    queue=new LinkedBlockingQueue<>(configuration.bufferSize);
    this.numberOfItems=configuration.numberOfItems;
    this.configuration=configuration;
   
    
  }

  @Override
  public long runProducerConsumerTest() {
    long startTime=System.currentTimeMillis();
    for(int i =0;i<configuration.numberOfProcuders;i++){
      new Thread(new Producer(queue,this)).start();
    }
    for(int i =0;i<configuration.numberOfConsumers;i++){
      new Thread(new Consumer(queue,this)).start();
    }
    while(numberOfItems>0){
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      }
    long resultTime= System.currentTimeMillis()-startTime;
    return resultTime;
    
  }
  public synchronized void decreaseItems(){
    numberOfItems--;
    //System.out.println(numberOfItems);
   // System.out.println(queue.remainingCapacity());
  }

  public int getNumberOfItems() {
    return numberOfItems;
  }

  public void setNumberOfItems(int numberOfItems) {
    this.numberOfItems = numberOfItems;
  }
  public static void main(String[] args){
    ProdConsProblem prob = new ProdConsProblem();
    prob.setUpTest(new Configuration());
    long result = prob.runProducerConsumerTest();
    System.out.print("result of test "+result+" numberofitems "+prob.getNumberOfItems());
  }
  

}


//---------------------------- Revision History ----------------------------
//$Log$
//
