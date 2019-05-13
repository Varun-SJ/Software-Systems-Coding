package ss.week7.account;

public class AccountSync {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account = new Account();
		Thread thread1 = new Thread(new MyThread(10000.0, 10000, account));
		Thread thread2 = new Thread(new MyThread(-10000.0, 10000, account));
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {}
		
		System.out.println(account.getBalance());

	}

}
