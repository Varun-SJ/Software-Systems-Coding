package ss.week7.account;

public class MyThread extends Thread {
	
	private double theAmount;
	private int theFrequency;
	private Account theAccount;
	
	public MyThread(double amount, int frequency, Account account) {
		this.theAmount = amount;
		this.theFrequency = frequency;
		this.theAccount = account;
	}

}
