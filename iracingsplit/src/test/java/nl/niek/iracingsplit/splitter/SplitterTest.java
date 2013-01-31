package nl.niek.iracingsplit.splitter;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import nl.niek.iracingsplit.driver.Driver;
import nl.niek.iracingsplit.driver.IDriverBuilder;
import nl.niek.iracingsplit.splitter.bucket.SplitBucket;

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
		List<Driver> drivers = getDefaultDriverList();

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
		List<SplitBucket> splits = splitter.split(builder);
		assertEquals(2, splits.size());
	}

	@Test
	public void testOneSplit()
	{
		List<Driver> drivers = getDefaultDriverList();
		drivers.remove(31);
		builder = new MockDriverBuilder(drivers);
		List<SplitBucket> splits = splitter.split(builder);
		assertEquals(2, splits.size());
	}

	@Test
	public void testExactMaxNumbersThreeSplits()
	{
		List<Driver> drivers = getDefaultDriverList();
		drivers.addAll(getDefaultDriverList());
		drivers.addAll(getDefaultDriverList());
		drivers.remove(1);
		drivers.remove(2);
		drivers.remove(3);

		builder = new MockDriverBuilder(drivers);
		List<SplitBucket> splits = splitter.split(builder);
		assertEquals(3, splits.size());
	}

	@Test
	public void testFourSplitsOneOver()
	{
		List<Driver> drivers = getDefaultDriverList();
		drivers.addAll(getDefaultDriverList());
		drivers.addAll(getDefaultDriverList());
		drivers.remove(1);
		drivers.remove(2);

		builder = new MockDriverBuilder(drivers);
		List<SplitBucket> splits = splitter.split(builder);
		assertEquals(4, splits.size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSplitNullBuilder()
	{
		splitter.split(null);
	}
	
	@Test
	public void testMockBuilderReturnNull()
	{
		builder = new MockDriverNullBuilder();
		List<SplitBucket> splits = splitter.split(builder);
		assertEquals(0, splits.size());
	}

	/**
	 * Testing class only.
	 * 
	 * @author Niek
	 * 
	 */
	private class MockDriverBuilder implements IDriverBuilder
	{
		private List<Driver>	drivers;

		MockDriverBuilder(List<Driver> drivers)
		{
			this.drivers = drivers;
		}

		@Override
		public List<Driver> getDrivers()
		{
			return drivers;
		}
	}

	/**
	 * Testing class only.
	 * 
	 * @author Niek
	 * 
	 */
	private class MockDriverNullBuilder implements IDriverBuilder
	{
		@Override
		public List<Driver> getDrivers()
		{
			return null;
		}
	}

	/**
	 * Get 31 drivers.
	 * 
	 * @return
	 */
	private List<Driver> getDefaultDriverList()
	{
		List<Driver> drivers = new ArrayList<Driver>();

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
		drivers.add(new Driver(4021));
		drivers.add(new Driver(4120));
		drivers.add(new Driver(4400));
		drivers.add(new Driver(4300));
		drivers.add(new Driver(4100));
		drivers.add(new Driver(4020));
		drivers.add(new Driver(4400));
		drivers.add(new Driver(3900));
		drivers.add(new Driver(4002));
		drivers.add(new Driver(4001));
		drivers.add(new Driver(5200));
		drivers.add(new Driver(4700));
		drivers.add(new Driver(4460));
		drivers.add(new Driver(5500));
		drivers.add(new Driver(5900));
		drivers.add(new Driver(6060));
		drivers.add(new Driver(8800));
		drivers.add(new Driver(9000));

		return drivers;
	}
}
