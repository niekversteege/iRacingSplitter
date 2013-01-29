package nl.niek.iracingsplit.drivers;

import static org.junit.Assert.fail;

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
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsFalse()
	{
		fail("Not yet implemented");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEqualsNotDriver()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testCompareTo()
	{
		fail("Not yet implemented");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testComareToNotDriver()
	{
		fail("Not yet implemented");
	}
}
