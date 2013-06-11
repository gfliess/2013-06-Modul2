package at.edu.hti.concurrency.prodcon;

public class Configuration {

	public int numberOfProcuders = 10;
	public int numberOfConsumers = 10;
	public int bufferSize = 5;
	public int numberOfItems = 1000000;

	public Configuration() {
	}

	public Configuration(int numberOfProcuders, int numberOfConsumers,
			int bufferSize, int numberOfItems) {
		super();
		this.numberOfProcuders = numberOfProcuders;
		this.numberOfConsumers = numberOfConsumers;
		this.bufferSize = bufferSize;
		this.numberOfItems = numberOfItems;
	}

	public int getNumberOfProcuders() {
		return numberOfProcuders;
	}

	public int getNumberOfConsumers() {
		return numberOfConsumers;
	}

	public int getBufferSize() {
		return bufferSize;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	@Override
	public String toString() {
		return "Configuration [numberOfProcuders=" + numberOfProcuders
				+ ", numberOfConsumers=" + numberOfConsumers + ", bufferSize="
				+ bufferSize + ", numberOfItems=" + numberOfItems + "]";
	}

}
