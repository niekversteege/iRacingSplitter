package nl.niek.iracingsplit.driver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class DriverTest
{
	private Driver	driver;

	@Before
	public void setUp() throws Exception
	{
		driver = new Driver(3424);
		driver.setName("Niek Versteege");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmptyNames()
	{
		driver = new Driver(2434);
		driver.setName("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullNames()
	{
		driver = new Driver(2434);
		driver.setName(null);
	}

	@Test
	public void testEqualsObject()
	{
		Driver anotherDriver = new Driver(3424);
		anotherDriver.setName("Niek Versteege");
		assertTrue(driver.equals(anotherDriver));
	}

	@Test
	public void testEqualsFalseIrating()
	{
		Driver anotherDriver = new Driver(3426);
		anotherDriver.setName("Niek Versteege");
		assertFalse(driver.equals(anotherDriver));
	}

	@Test
	public void testEqualsFalseFirstName()
	{
		Driver anotherDriver = new Driver(3424);
		anotherDriver.setName("asdf Versteege");
		assertFalse(driver.equals(anotherDriver));
	}

	@Test
	public void testEqualsFalseLastName()
	{
		Driver anotherDriver = new Driver(3424);
		anotherDriver.setName("Niek asdf");
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
		anotherDriver.setName("asdf fdds");
		assertEquals(0, driver.compareTo(anotherDriver));
	}

	@Test
	public void testCompareToSmaller()
	{
		Driver anotherDriver = new Driver(3423);
		anotherDriver.setName("asdf fdds");
		assertEquals(1, driver.compareTo(anotherDriver));
	}

	@Test
	public void testCompareToBigger()
	{
		Driver anotherDriver = new Driver(3425);
		anotherDriver.setName("asdf fdds");
		assertEquals(-1, driver.compareTo(anotherDriver));
	}

	private class MockDriver
	{

	}
}
