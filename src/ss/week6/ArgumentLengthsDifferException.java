package ss.week6;

public class ArgumentLengthsDifferException extends WrongArgumentException {
	
	private String s1;
	private String s2;
	
	public ArgumentLengthsDifferException(String s1, String s2) {
		super();
		this.s1 = s1;
		this.s2 = s2;
	}
	
	public String getMessage() {
		return "error: length of cmd line args differ (" + s1.length()+ "," + s2.length() + ")";
	}

}
