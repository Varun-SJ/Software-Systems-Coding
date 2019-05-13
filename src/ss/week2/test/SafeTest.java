package ss.week2.test;

import static org.junit.jupiter.api.Assertions.*;
import ss.week2.hotel.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SafeTest {
	
	private Safe safe1;
	private Safe safe2;
	public static final String NEWPASS = "password123";

	@BeforeEach
	void setUp() throws Exception {
		safe1 = new Safe(NEWPASS);
		safe2 = new Safe(NEWPASS);
		
	}

	@Test
	void test() {
		safe1.activate(NEWPASS);
		assertTrue(safe1.isActive());
		assertTrue(safe1.getPassword().testWord(NEWPASS));
		safe1.deactivate();
		assertFalse(safe1.isActive());
		
		
	}

	
	@Test
	void testInitial() {
		assertFalse(safe1.isActive());
		assertFalse(safe1.isOpen());
	}

	@Test
	void testActivateCorrectPassword(){
		safe1.activate("password123");
		assertTrue(safe1.isActive());	
	}

	@Test
	void testActivateWrongPassword() {
		safe1.activate("FalsePassword");
		assertFalse(safe1.isActive());
	}

	@Test
	void testOpenCorrectPasswordNotActive() {
		safe2.open("password123");
		assertFalse(safe2.isOpen());
	}
	@Test
	void testOpenCorrectPasswordActive() {
		safe1.activate("password123");
		safe1.open("password123");
		assertTrue(safe1.isOpen());
	}
	@Test
	void testOpenIncorrectPasswordNotActive() {
		safe1.open("FalsePassword");
		assertFalse(safe1.isOpen());
	}
	@Test
	void testOpenIncorrectPasswordActive() {
		safe1.activate("password123");
		safe1.open("FalsePassword");
		assertFalse(safe1.isOpen());
	}
	@Test
	void testActivateOpenDeactivate() {
		safe1.activate("password123");
		safe1.open("password123");
		safe1.deactivate();
		assertFalse(safe1.isActive());
		assertFalse(safe1.isOpen());
		
	}
}


