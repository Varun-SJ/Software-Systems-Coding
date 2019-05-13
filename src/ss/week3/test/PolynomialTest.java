package ss.week3.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ss.week3.math.Polynomial;

public class PolynomialTest {
	private Polynomial polynomial;
	private double[] f = {3,3};

	@BeforeEach
	void setUp() throws Exception {
		polynomial = new Polynomial(f);
	}

	@Test
	public void testApplyf1() {
		assertEquals(6,polynomial.apply(1),0.0001);
	}
	
	@Test
	public void testApplyf2() {
		assertEquals(18, polynomial.apply(2),0.0001);
		
	}
	@Test
	public void testDerivative1() {
		System.out.println(polynomial.derivative());
		assertEquals(9,polynomial.derivative().apply(1),0.0001);
	}
	
	@Test
	public void testDerivative2() {
		assertEquals(6,polynomial.derivative().derivative().apply(2),0.0001);
		
	}
	
	@Test
	public void testDerivative3() {
		assertEquals(0,polynomial.derivative().derivative().derivative().apply(1),0.0001);
	}
	
	@Test 
	public void testIntegral() {
		assertEquals(2.5, polynomial.integral().apply(1),0.001);
	}
	
	
	

}
