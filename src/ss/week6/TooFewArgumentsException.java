package ss.week6;

public class TooFewArgumentsException extends WrongArgumentException{
	
	@Override
	public String getMessage() {
		return "error: must pass two cmdln args";
	}

}
