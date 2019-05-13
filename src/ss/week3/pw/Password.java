package ss.week3.pw;
import java.lang.System.*;


public class Password {
	
	private String initial;
	private String CurrentPass;
	public Checker checker;
	
	public Password(Checker checker) {
		this.checker = checker;
		this.initial = checker.generatePassword();
		this.CurrentPass = initial;
		}
	
	public Password() {
		this(new BasicChecker());
		}
	
	public boolean acceptable(String suggestion) {
		if (suggestion.length() < 6 || suggestion.contains(" ")) 
			return false;
		else 
			return true;
		}
	
	
	public boolean testWord(String test) {
		if (test.equals(CurrentPass))
				return true;
		else
			return false;
		
	}
	
	public boolean setWord(String oldpass, String newpass) {
		if(oldpass.equals(initial) && acceptable(newpass)) {
			CurrentPass = newpass;
			return true;
		}
		else 
			return false;
			
		
	}
	

}
