
package at.edu.hti.concurrency.stores;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import at.edu.hti.concurrency.Store;

public class StoreImplAmarktlEherf implements Store {

  private List<String> items = new CopyOnWriteArrayList<String>();
  private int maxSize = 0;

  /** {@inheritDoc} */
  @Override
  public String getName() {
    return "AMARKTL-EHERF";
  }

  /** {@inheritDoc} */
  @Override
  public void initMaxSize(int maxSize) {
    if (maxSize <= 0) {
      throw new IllegalArgumentException("'items' must not be less or equal than 0");
    }
    this.maxSize = maxSize;
  }

  /** {@inheritDoc} */
  @Override
  public void addFirst(String data) {
    items.add(0, data);
  }

  /** {@inheritDoc} */
  @Override
  public String removeLast() {
    return items.remove(items.size() - 1);
  }

  /** {@inheritDoc} */
  @Override
  public String removeItem(int index) {
    return items.remove(index);
  }

  /** {@inheritDoc} */
  @Override
  public int size() {
    return items.size();
  }
}

//---------------------------- Revision History ----------------------------
//$Log$
//
