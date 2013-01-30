package nl.niek.iracingsplit.splitter;

import static org.junit.Assert.fail;

import java.util.HashSet;
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
		Set<Driver> drivers = getDefaultDriverList();

		builder = new MockDriverBuilder(drivers);

		splitter = new Splitter(MAX_CARS_ON_TRACK, MIN_DRIVERS,
				IRATING_TRESHOLD);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTresholdTooBig()
	{
		splitter = new Splitter(MAX_CARS_ON_TRACK, MIN_DRIVERS, 110);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMinDriversLargerThanMaxCars()
	{
		splitter = new Splitter(MAX_CARS_ON_TRACK, 31, IRATING_TRESHOLD);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMaxCarsTooBig()
	{
		splitter = new Splitter(66, MIN_DRIVERS, IRATING_TRESHOLD);
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
	
	/**
	 * Get 31 drivers. 
	 * @return
	 */
	private Set<Driver> getDefaultDriverList()
	{
		Set<Driver> drivers = new HashSet<Driver>();
		
		drivers.add(new Driver(2000));
		drivers.add(new Driver(2200));
		drivers.add(new Driver(2300));
		drivers.add(new Driver(2400));
		drivers.add(new Driver(2500));
		drivers.add(new Driver(2600));
		drivers.add(new Driver(2650));
		drivers.add(new Driver(2200));
		drivers.add(new Driver(2100));
		drivers.add(new Driver(2240));
		drivers.add(new Driver(3300));
		drivers.add(new Driver(3200));
		drivers.add(new Driver(4000));
		drivers.add(new Driver(4000));
		drivers.add(new Driver(4000));
		drivers.add(new Driver(4000));
		drivers.add(new Driver(4000));
		drivers.add(new Driver(4000));
		drivers.add(new Driver(4000));
		drivers.add(new Driver(4000));
		drivers.add(new Driver(4000));
		drivers.add(new Driver(4000));
		drivers.add(new Driver(4000));
		drivers.add(new Driver(4000));
		drivers.add(new Driver(4000));
		drivers.add(new Driver(4000));
		drivers.add(new Driver(4000));
		drivers.add(new Driver(4000));
		drivers.add(new Driver(4000));
		drivers.add(new Driver(4000));
		drivers.add(new Driver(4000));
		
		return drivers;
	}
}
