package ss.week1;

public class TWL {
	
	/*
	 * @private invariant OFF == 0 && LOW == 1 && MED == 2 && HIGH == 3
	 * @private invariant settings >= 0 && settings <= 3
	 */
	
	private static final int OFF = 0;
	private static final int LOW = 1;
	private static final int MED = 2;
	private static final int HIGH = 3;
	private int settings;
	
	/*
	 * Constructor for three Way Lamp
	 * @require this.setting == OFF
	 */
	public TWL() {
		assert this.settings == OFF;
		// TODO Auto-generated constructor stub
		this.settings = OFF;
		
	}
	
	/*@
	 * ensure \old(getSettings()) == OFF ==> getSettings() == OFF
	 * @ensure \old(getSetting()) == LOW ==> getSettings() == LOW
	 * @ensure \old(getSettings()) == MED ==> getSettings() == MED
	 * @ensure \old(getSettings()) == OFF ==> getSettings() == HIGH
	 * @pure
	 */
	
	public int switchSetting (int setting) {
		assert setting >= 0 && setting <= 3;
		if ((setting+1) % (HIGH + 1) == OFF ) {
			this.setSettings(OFF); 
		}
		else if ((setting+1) % (HIGH + 1) == LOW ) {
			this.setSettings(LOW); 
		}
		else if ((setting+1) % (HIGH + 1) == MED ) {
			this.setSettings(MED);
		}
		else if ((setting+1) % (HIGH + 1) == HIGH ) {
			this.setSettings(HIGH); 
		}
		
		return this.getSettings();
	}
	
	/*
	 * @pure
	 * @ensure \result == settings
	 */
	public int getSettings() {
		assert settings >= 0 && settings <= 3;
		return settings;
	}
	
	/*
	 * @ensure this.settings == settings
	 */

	public void setSettings(int settings) {
		assert this.settings == settings;
		this.settings = settings;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * @pure
	 */
	public String toString() {
		return "TWL [settings=" + settings + "]";
	}

	
}