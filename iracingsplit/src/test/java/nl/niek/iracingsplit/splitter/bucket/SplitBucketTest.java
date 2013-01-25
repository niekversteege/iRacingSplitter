package nl.niek.iracingsplit.splitter.bucket;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import nl.niek.iracingsplit.drivers.Driver;

import org.junit.Before;
import org.junit.Test;

public class SplitBucketTest
{
	SplitBucket bucket;
	
	List<Driver> drivers;

	@Before
	public void setUp() throws Exception
	{
		bucket = new SplitBucket();
		drivers = new ArrayList<Driver>();
		
		drivers.add(new Driver("Niek", "Versteege", 4000));
	}

	@Test
	public void testSplitBucket()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSplitBucketCollectionOfDriver()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testAdd()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testAvgIrating()
	{
		fail("Not yet implemented");
	}

}
