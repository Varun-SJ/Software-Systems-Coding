package ss.week1;

public class Password {
	
	public static final String INITIAL = "INITIAL";
	private String CurrentPass = INITIAL;
	
	public Password(String password) {
		CurrentPass = password;
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
		if(oldpass.equals(INITIAL) && acceptable(newpass)) {
			CurrentPass = newpass;
			return true;
		}
		else 
			return false;
			
		
	}
	

}
