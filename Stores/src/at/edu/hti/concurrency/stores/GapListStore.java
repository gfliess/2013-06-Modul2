package at.edu.hti.concurrency.stores;

import at.edu.hti.concurrency.Store;



/**
 * http://java.dzone.com/articles/gaplist-lightning-fast-list
 *
 */
public class GapListStore implements Store {

	private GapList<String> _elements;
	
	
	@Override
	public String getName() {
		return "GAPList";
	}

	@Override
	public void initMaxSize(int maxSize) {
		_elements = new GapList<String>(maxSize);
	}

	@Override
	public void addFirst(String data) {
		_elements.addFirst(data);
	}

	@Override
	public String removeLast() {
		
		return _elements.removeLast();
	}

	@Override
	public String removeItem(int index) {
		try {
			return _elements.get(index);
		}
		finally{
			_elements.remove(index);
		}
	}

	@Override
	public int size() {
		return _elements.size();
	}

}
