 package ss.week2.hotel;

/**
 * Guest name and possibly a room allocation with checkin and checkout ability.
 * @author Varun Sudhakar
 */

public class Guest {
	
	private String name;
	private Room room;
	
	// ------------------ Constructor ------------------------
    /**
     * Creates a <code>Guest</code> with the given String name.
     * @param this.name is equal to name in the <code>Guest</code>
     */
	
	
	public Guest(String name) {
		this.name = name;
	}
	
	// ------------------ Queries --------------------------
    /**
     * Returns the name of this Guest.
     */
	public String getName() {
		return name;
	}
	
	/**
     * Returns the current room in this <code>Room</code>.
     * @return the room of this <code>Room</code>;
     *         
     */

	public Room getRoom() {
		return room;
	}
	
	/** The status of whether the room has been checked in or out.*/
	
	/**public boolean checkin(Room room) {
		if (room.getGuest() == null) {
			room.setGuest() = room;  
		}
		else
			return false;
	}*/
	
	public boolean checkin(Room room) {
		if (room.getGuest() != null && this.room != null) {
			return false;
		}else {
			
			room.setGuest(this);
			this.room = room;
			return true;
		}
	}
	
	
	public boolean checkout() {
		if (this.room == null) {
			return false;
		}else {
			this.room.setGuest(null);
			this.room = null;
			return true;
		}
		
	}
	
	public String toString() {
		return "Guest Name: " + this.name;
	}

}
