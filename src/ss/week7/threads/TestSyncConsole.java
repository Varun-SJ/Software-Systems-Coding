package ss.week7.threads;

//import java.concurrency.util.locks;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestSyncConsole {

	String threadName;
	private final Lock lock = new ReentrantLock();

	public TestSyncConsole(String threadName) {
		this.threadName = threadName;
	}

	synchronized public void sum() {
		lock.lock();
		int num1 = Console.readInt(threadName + ": Get num 1: ");
		int num2 = Console.readInt(threadName + ": Get num 2: ");
		Console.println(threadName + ": " + num1 + " + " + num2 + " = " + (num1 + num2));
		lock.unlock();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestConsole console = new TestConsole("Thread 1");
		console.sum();
		TestConsole console2 = new TestConsole("Thread 2");
		console2.sum();

	}

}
