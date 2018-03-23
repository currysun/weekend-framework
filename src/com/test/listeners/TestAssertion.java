package com.test.listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.test.util.Assertions;

@Listeners(AssertionsListener.class)
public class TestAssertion {
	@Test
	public void testAssert() {
		
		Assertions.verifyEquals(2, 3);
		
	}
}
