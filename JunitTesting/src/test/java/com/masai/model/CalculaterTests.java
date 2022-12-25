package com.masai.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class CalculaterTests {
	@BeforeAll					// static method only if not than give error/exception
	public static void beforeTesting() {
		System.out.println("Start Testing...............!");
	}
	
	@BeforeEach
	public void beforeReady() {
		System.out.println("Start Testing of Method");
	}
	
	@Test
	public void addTwoNumbersTest() {
		Calculator c = new Calculator();
		assertEquals(17, c.calculateAdd(9, 8));
	}
	
	
	@Test
	@Disabled
	public void notRequired() {
		System.out.println("Not Testing of Method");
	}
	
	@RepeatedTest(5)
	public void repeatRequired() {
		System.out.println("Repeat Testing of Method");
	}
	
	@Test
	@DisplayName("Changing Name")
	public void dummyRequired() {
		System.out.println("Another Name Testing of Method");
		assertFalse(false); // if check any method return false or not
		assertTrue(true);   // if check any method return true or not
		assertNull(null);   // object is null or any method return null or not
		assertNotNull(new Calculator()); // check object or any method return null or not
		assertThrows(ClassCastException.class,()->new Calculator().calculateMulti(12, "abs") );
		// check exception
		assertNotEquals(12, 13); // check for not equal
		
		assertAll(		// For many test cases at one time inside that
				()-> assertNotEquals(12, 13),
				()-> assertFalse(false)
				);
	}
	

	@AfterEach
	public void afterCompleted() {
		System.out.println("Completed Testing of Method");
	}
	
	@AfterAll						// static method only if not than give error/exception
	public static void afterTesting() {
		System.out.println("Completed Testing...............!");
	}

}
