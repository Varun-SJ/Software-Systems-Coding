package ss.week7.threads;

public class TestConsole extends Thread {
	
	String threadName;
	
	public TestConsole(String threadName) {
		this.threadName = threadName;
	}
	
	public void sum() {
		int num1 = Console.readInt(threadName + ": Get num 1: " );
		int num2 = Console.readInt(threadName + ": Get num 2: ");
		Console.println(threadName + ": " + num1 + " + " + num2 + " = " + (num1+num2));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestConsole console = new TestConsole("Thread 1");	
		console.sum();
		TestConsole console2 = new TestConsole("Thread 2");
		console2.sum();
		

	}

}
