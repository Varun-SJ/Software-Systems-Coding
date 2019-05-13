package ss.week3.pw;
import java.lang.Character.*;

public class StrongChecker extends BasicChecker {
	
	public boolean startsLetter(String suggestion) {
		return Character.isLetter(suggestion.charAt(0)) && Character.isDigit(suggestion.charAt(suggestion.length() - 1));
		
	}

}
