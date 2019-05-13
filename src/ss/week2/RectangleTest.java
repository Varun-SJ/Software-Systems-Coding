package ss.week2;
import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RectangleTest {
	
	private Rectangle rectangle1;

	@BeforeEach
	void setUp() throws Exception {
		rectangle1 = new Rectangle(3,4);	
		}

	@Test
	void testarea() {
		assertEquals (12, rectangle1.area());
		
	}
	void testperimeter() {
		assertEquals (14, rectangle1.perimeter());
	}

}
