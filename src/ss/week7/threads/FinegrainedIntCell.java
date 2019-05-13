package ss.week7.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FinegrainedIntCell implements IntCell {
	private boolean written = false;
	private int value = 0;

	private final Lock lock;
	private final Condition doWrite;
	private final Condition doRead;

	public FinegrainedIntCell() {
		lock = new ReentrantLock();
		doWrite = lock.newCondition();
		doRead = lock.newCondition();
	}

	public void setValue(int valueArg) {
		lock.lock();
		while (written) {
			try {
				doWrite.await();
			} catch (InterruptedException e) {
			}
		}
		this.value = valueArg;
		written = true;
		doRead.signal();
		lock.unlock();
	}

	public int getValue() {
		lock.lock();
		while (!written) {
			try {
				doRead.await();
			} catch (InterruptedException e) {
			}
		}
		doWrite.signal();
		int tmpval = value;
		written = false;
		lock.unlock();
		return tmpval;
	}
}
