package ss.week7.threads;

/**
 * Incorrect communication between IntProducer en IntConsumer.
 */
public class NotifyIntCell implements IntCell {
	private boolean written = false;
	private int value = 0;

	public synchronized void setValue(int valueArg) {
		while (written) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		this.value = valueArg;
		written = true;
		notifyAll();
	}

	public synchronized int getValue() {
		while (!written) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		written = false;
		notifyAll();
		return value;
	}
}