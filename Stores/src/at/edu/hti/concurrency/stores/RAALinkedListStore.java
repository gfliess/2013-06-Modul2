/** 
 * Copyright 2013 SSI Schaefer PEEM GmbH. All Rights reserved. 
 * <br /> <br />
 * 
 * $Id$
 * <br /> <br />
 *
 */

package at.edu.hti.concurrency.stores;

import java.util.LinkedList;
import java.util.List;

import at.edu.hti.concurrency.Store;

/**
 * This is the class header. The first sentence (ending with "."+SPACE) is important, because it is
 * used summary in the package overview pages.<br />
 * <br />
 * 
 * @author ara
 * @version $Revision$
 * @param <T>
 */

public class RAALinkedListStore<T> implements Store {

  LinkedList<String> linkedList;
  int maxSize = 0;

  @Override
  public String getName() {
    return "LinkedListStore";
  }

  @Override
  public void initMaxSize(int maxSize) {
    linkedList = new LinkedList<String>();
    this.maxSize = maxSize;
  }

  @Override
  public void addFirst(String data) {
    if (linkedList.size() < maxSize) {
      linkedList.addFirst(data);
    } else {
      throw new ArrayIndexOutOfBoundsException("maximal größe der Liste übershritten");
    }

  }

  @Override
  public String removeLast() {
    return linkedList.removeLast();
  }

  @Override
  public String removeItem(int index) {

    return linkedList.remove(index);
  }

  @Override
  public int size() {
    return linkedList.size();
  }

}

//---------------------------- Revision History ----------------------------
//$Log$
//
