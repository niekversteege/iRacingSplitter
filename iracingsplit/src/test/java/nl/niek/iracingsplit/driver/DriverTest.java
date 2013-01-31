package nl.niek.iracingsplit.driver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import nl.niek.iracingsplit.driver.Driver;

import org.junit.Before;
import org.junit.Test;

public class DriverTest
{
	private Driver	driver;

	@Before
	public void setUp() throws Exception
	{
		driver = new Driver(3424);
		driver.setNames("Niek", "Versteege");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmptyNames()
	{
		driver = new Driver(2434);
		driver.setNames("", "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullNames()
	{
		driver = new Driver(2434);
		driver.setNames(null, null);
	}

	@Test
	public void testEqualsObject()
	{
		Driver anotherDriver = new Driver(3424);
		anotherDriver.setNames("Niek", "Versteege");
		assertTrue(driver.equals(anotherDriver));
	}

	@Test
	public void testEqualsFalseIrating()
	{
		Driver anotherDriver = new Driver(3426);
		anotherDriver.setNames("Niek", "Versteege");
		assertFalse(driver.equals(anotherDriver));
	}
	
	@Test
	public void testEqualsFalseFirstName()
	{
		Driver anotherDriver = new Driver(3424);
		anotherDriver.setNames("asdf", "Versteege");
		assertFalse(driver.equals(anotherDriver));
	}
	
	@Test
	public void testEqualsFalseLastName()
	{
		Driver anotherDriver = new Driver(3424);
		anotherDriver.setNames("Niek", "asdf");
		assertFalse(driver.equals(anotherDriver));
	}

	@Test
	public void testEqualsNotDriver()
	{
		assertFalse(driver.equals(new MockDriver()));
	}

	@Test
	public void testCompareTo()
	{
		Driver anotherDriver = new Driver(3424);
		anotherDriver.setNames("asdf", "fdds");
		assertEquals(0, driver.compareTo(anotherDriver));
	}

	@Test
	public void testCompareToSmaller()
	{
		Driver anotherDriver = new Driver(3423);
		anotherDriver.setNames("asdf", "fdds");
		assertEquals(1, driver.compareTo(anotherDriver));
	}

	@Test
	public void testCompareToBigger()
	{
		Driver anotherDriver = new Driver(3425);
		anotherDriver.setNames("asdf", "fdds");
		assertEquals(-1, driver.compareTo(anotherDriver));
	}

	private class MockDriver
	{

	}
}
