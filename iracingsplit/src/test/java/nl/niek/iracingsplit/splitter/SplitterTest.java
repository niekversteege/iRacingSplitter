package nl.niek.iracingsplit.splitter;

import static org.junit.Assert.fail;

import java.util.Set;

import nl.niek.iracingsplit.driver.Driver;
import nl.niek.iracingsplit.driver.IDriverBuilder;

import org.junit.Before;
import org.junit.Test;

public class SplitterTest
{
	private IDriverBuilder		builder;
	private Splitter			splitter;
	private static final int	MAX_CARS_ON_TRACK	= 30;
	private static final int	MIN_DRIVERS			= 10;
	private static final int	IRATING_TRESHOLD	= 10;

	@Before
	public void setUp() throws Exception
	{
		builder = new MockDriverBuilder(null);

		splitter = new Splitter(MAX_CARS_ON_TRACK, MIN_DRIVERS,
				IRATING_TRESHOLD);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTresholdTooBig()
	{
		fail("Not yet implemented");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMinDriversTooLarge()
	{
		fail("Not yet implemented");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMinDriversLargerThanMaxCars()
	{
		fail("Not yet implemented");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMaxCarsTooBig()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSplit()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testOneSplit()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testExactMaxNumbers()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSplitNullBuilder()
	{
		fail("Not yet implemented");
	}

	/**
	 * Testing class only.
	 * 
	 * @author Niek
	 * 
	 */
	private class MockDriverBuilder implements IDriverBuilder
	{
		private Set<Driver>	drivers;

		MockDriverBuilder(Set<Driver> drivers)
		{
			this.drivers = drivers;
		}

		@Override
		public Set<Driver> getDrivers()
		{
			return drivers;
		}

	}
}
