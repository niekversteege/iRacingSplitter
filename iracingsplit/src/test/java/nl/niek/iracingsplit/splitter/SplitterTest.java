package nl.niek.iracingsplit.splitter;

import static org.junit.Assert.fail;

import java.util.Set;

import nl.niek.iracingsplit.driver.Driver;
import nl.niek.iracingsplit.driver.factory.IDriverBuilder;

import org.junit.Before;
import org.junit.Test;

public class SplitterTest
{
	private IDriverBuilder	builder;

	@Before
	public void setUp() throws Exception
	{
		builder = new MockDriverBuilder(null);
	}

	@Test
	public void testCreationBoundaries()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSplit()
	{
		fail("Not yet implemented");
	}

	private class MockDriverBuilder implements IDriverBuilder
	{
		private Set<Driver> drivers;
		
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
