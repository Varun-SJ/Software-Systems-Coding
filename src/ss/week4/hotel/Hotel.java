/**
 * 
 */
package ss.week4.hotel;
//import ss.week3.bill.Bill.Item;

/**
 * @author Varun Sudhakar
 *
 */
public class Hotel {
	private String name;
	private /*@spec_public*/ Room room1; 
	private /*@spec_public*/ Room room2; 
	private Password password;
	
	
	/**
	 * Creating Constructor
	 */
	//@requires name != null;
	
	public Hotel(String name) {
		this.password = new Password();
		this.room1 = new PricedRoom(123,215.12,10);
		this.room2 = new Room(124);
		this.name = name;
		
		
		
	}
	
	/**
	 * Query for getFreeRoom
	 * @pure
	 */
	/*@
	 @ensures room1.getGuest() == null ==> \result == room1 ||
	  room2.getGuest() == null ==> \result == room2 ||
	 \result == null;
	 */
	
	public Room getFreeRoom() {
		if(room1.getGuest() == null) {
			return room1;
		}
		else if(room2.getGuest() == null) {
			return room2;
		}
		else {
			return null;
		}
		
		
	}
	
	/**
	 * Query for getRoom.
	 * @pure
	 */
	/*@
	 * requires room1.getGuest() != null & room1.getGuest().getName().equals(name) ==> \result = room1 ||
	 * room2.getGuest() != null && room2.getGuest().getName().equals(name) ==> \result = room2 ||
	 * \result = null;
	 */
	
	public Room getRoom(String name) {
		if (room1.getGuest() != null && room1.getGuest().getName().equals(name)) {
			return room1;
		}
		else if (room2.getGuest() != null && room2.getGuest().getName().equals(name)) {
			return room2;
		}
		else {
			return null;
		}
		
	}
	
	
	/**
	 * Query for getPassword.
	 * @pure
	 */
	/*@
	 * ensures \result = password;
	 */
	public Password getPassword() {
		return password;
		
	}
	
	/*
	 * Command for Checking in
	 */
	/*@
	 @requires mypassword.testWord(password) && getRoom(name) && Room freeRoom  == true ==>
	 Guest guest = new Guest(name) ==> guest.checkin(freeRoom);
	 @ensures \result = freeRoom;
	 @requires mypassword.testWord(password) || getRoom(name) || Room freeRoom  == false;
	 @ensures \result = null;
	 */
	
	
		public Room checkIn(String password1, String guestname) {
			if (getFreeRoom() != null  && getPassword().testWord(password1) && getRoom(guestname) == null) {
				Guest guest = new Guest(guestname);
				Room temproom = getFreeRoom();
				temproom.setGuest(guest);
				guest.checkin(temproom);
				return temproom;
			} 
			else {
				return null;
			}
		}
	
	/**
	 * Command for Checking out
	 */
		/*@
	 @requires Room oldRoom = getRoom(name);
	 @requires !oldRoom = null;
	 @ensures oldRoom.getGuest().checkout() && oldRoom.getSafe().deactivate(); 
	 */
	
	public void checkOut(String name) {
		Room oldRoom = getRoom(name);
		if (oldRoom != null) {
			oldRoom.getGuest().checkout();
			oldRoom.getSafe().deactivate();
			//oldRoom.getSafe().close();
		}
		else {
			System.out.println("Guest couldnt checkout");
			
		}
		
		
	}
	
	
	
	/**
	 * Query toString
	 */
	@Override
	public String toString() {
		if(room1.getGuest() != null && room2.getGuest() != null) {
			return ("Room 1: " + room1.getGuest().getName() + "Room 2: " + room2.getGuest().getName());
	}
	return "";
	}
	
	public Bill getBill (String name,int nightsspent, Printer printer) {
		
		if (getRoom(name)instanceof PricedRoom) {
			Bill bill = new Bill (printer);
			for (int i = 0; i< nightsspent; i++) {
				bill.addItem(((PricedRoom) getRoom(name))); 
			}
			bill.addItem((PricedSafe) ((PricedRoom) getRoom(name)).getSafe());
			return bill;
		}
		return null;
	}
		
	
	
	
	
	
	
	
	
	
	

	}


