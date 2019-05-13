package ss.week3.pw;
import java.lang.System.*;

public class TimedPassword extends Password {
	
	/*
	 * Iniializing the field
	 */
	
	/*@ non_null*/private long validTime;
	/*@non_null*/private long startTime; 
	/*@ invariant*/public static final long DEFAULT_VALID_TIME = 5000;
	
	
	
	/*@
	 * @requires validTime != (null || <= 0); 
	 * @ensures validTime == getValidTime();
	 */
	
public TimedPassword(long validTime)  {
		
		this.startTime = System.currentTimeMillis();
		this.validTime = validTime;
		System.out.println(startTime);

		
	}
	
	//@ ensures getValidTime() = DEFAULT_VALID_TIME;
	public TimedPassword() {
		this(DEFAULT_VALID_TIME);
		
	}
	
	/*
	 * @pure
	 * @ requires startTime = System.currentTimeMillis();
	 * @ ensures \result == true || false; 
	 * 
	 * 
	 */
	
	@Override
	//@ ensures acceptable(newpass);
	//@pure
	
	public boolean setWord(String oldpass, String newpass) {
		
		if (super.setWord(oldpass, newpass)) {
			startTime = System.currentTimeMillis();
			return true;	
		} 
			return false;
		
			
		
	}
	
	/*
	 * @ensures validTime = expirationTime;
	 */
	
	public void setExpTime(long expirationTime) {
		this.validTime = expirationTime;
	}
	
	/*@
	 * @pure
	 * @ensures System.currentTimeMillis() - startTime > validTime ==> \result = true;
	 * @ensures System.currentTimeMillis() - startTime < validTime ==> \result = false;
	 * 
	 */
	
	
	public boolean isExpired() {
		return ((System.currentTimeMillis() - startTime) > validTime);
	} 
	
	/*@
	 * @pure
	 * @ ensures \result = validTime;
	 */
	
	public long getValidTime() {
		return validTime;
	}
	
	
	

		
	}
