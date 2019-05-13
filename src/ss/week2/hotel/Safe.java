/**
 * 
 */
package ss.week2.hotel;
import ss.week2.hotel.*;

/**
 * @author Varun Sudhakar
 *Creating a safe for a hotel room
 */


public class Safe {
	
	/**
	 * @invariant open = true ==> active;
	 * 
	 */
	private Password mypassword;
	public boolean active;
	public boolean open;
	
	
	
	/**
	 * Creating a constructor 
	 * Creating a new instance of Password
	 * @ensure mypassword != null;
	 * mypassword = new Password()
	 */
	
	public Safe (String newpass) {
		mypassword = new Password(newpass);
		
	}
	
	/**
	 * @requires isOpen() == false &&
	 * isActive() == false;
	 * @ensures isActive() == true && isOpen() == false;
	 */
	
	public void activate (String string ) {
		//assert isOpen() == false && isActive() == false;
		if (mypassword.testWord(string) == true) {
			active = true;
		}
	}
	
	/**
	 * @requires isActive() == true ;
	 * @ensures isActive()== false && isOpen() == false;
	 */
	
	public void deactivate () {
		//assert isActive() == true;
		active = false;
		open = false;	
	}
	
	/**
	 * @require isActive() = true && mypassword.testWord(string) = true;
	 * @ensures open = true;
	 */
	public void open (String string) {
		//assert isActive() && mypassword.testWord(string);
		if (isActive() && mypassword.testWord(string)) {
			open = true;
		}
		
	}
	
	/**
	 * @requires isActive() = true && isOpen() = true;
	 * @ensures isOpen() = false;
	 */
	public void close () {
		//assert isActive() && isOpen();
		open = false;
		
	}
	
	/**
	 * @pure
	 * @ensures \result = true || \result = false
	 */
	public boolean isActive() {
		return active;
	}
	
	/**
	 * @pure
	 * @ensures \result = true || \result = false 
	 */
	
	public boolean isOpen() {
		return open;
	}
	
	/**
	 * @pure
	 * \result = mypassword
	 */
	public Password getPassword(){
		return mypassword;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Safe safe1;
		safe1 = new Safe("passvarun123");
		safe1.open("passvarun123");
		System.out.println("Test open: " + safe1.isOpen());
		

	}
	
}
