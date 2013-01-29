package nl.niek.iracingsplit;

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
		driver = new Driver("Niek", "Versteege", 3424);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmptyNames()
	{
		driver = new Driver("", "", 2434);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullNames()
	{
		driver = new Driver(null, null, 2434);
	}

	@Test
	public void testEqualsObject()
	{
		assertTrue(driver.equals(new Driver("Niek", "Versteege", 3424)));
	}

	@Test
	public void testEqualsFalse()
	{
		assertFalse(driver.equals(new Driver("Niek", "Versteege", 3624)));
	}

	@Test
	public void testEqualsNotDriver()
	{
		assertFalse(driver.equals(new MockDriver()));
	}

	@Test
	public void testCompareTo()
	{
		assertEquals(0, driver.compareTo(new Driver("asdf", "fdds", 3424)));
	}

	@Test
	public void testCompareToSmaller()
	{
		assertEquals(1, driver.compareTo(new Driver("asdf", "fdds", 3423)));
	}

	@Test
	public void testCompareToBigger()
	{
		assertEquals(-1, driver.compareTo(new Driver("asdf", "fdds", 3425)));
	}

	private class MockDriver
	{

	}
}
