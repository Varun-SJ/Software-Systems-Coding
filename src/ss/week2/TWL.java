package ss.week2;

public class TWL {
	
public enum States {
		
		OFF ,
		LOW ,
		MED ,
		HIGH;
};
	private States status;

	/**
	 * @param status
	 */
	public TWL() {
		this.status = (States.OFF);
	}
	
	/*
	 * @ensure old(status == States.OFF) ==> status == States.LOW
	 * @ensure old(status = States.LOW) ==> status = States.MED
	 * @ensure old(status = States.MED) ==> status = States.HIGH
	 * @ensure old(status = States.HIGH) ==> status = States.OFF		 
	 */
	
	public void switchStates() {
		switch (status) {
		case OFF:
			status = States.LOW;
			break;
		case LOW:
			status = States.MED;
			break;
		case MED:
			status = States.HIGH;
			break;
		case HIGH:
			status = States.OFF;
			break;
		}
			
		
		
		
	}
	
	/*
	 * Getters
	 * @pure
	 * @ensure \result == status
	 */

	public States getStatus() {
		return status;
	}
	
	/*
	 * Setters
	 * @require this.status = status 
	 */

	public void setStatus(States status) {
		this.status = status;
	}
	
	

}