package nl.niek.iracingsplit.splitter.bucket;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.HashSet;
import java.util.Set;

import nl.niek.iracingsplit.driver.Driver;

import org.junit.Before;
import org.junit.Test;

public class SplitBucketTest
{
	private SplitBucket	bucket;

	private Set<Driver>	drivers;

	@Before
	public void setUp() throws Exception
	{
		drivers = new HashSet<Driver>();
		drivers.add(new Driver(4600));
		drivers.add(new Driver(3600));
		drivers.add(new Driver(5200));
		drivers.add(new Driver(3000));
		drivers.add(new Driver(3000));
		drivers.add(new Driver(4600));

		bucket = new SplitBucket(drivers);
	}

	@Test
	public void testSplitBucket()
	{
		assertFalse(bucket.isEmpty());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSplitBucketNull()
	{
		bucket = new SplitBucket(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSplitBucketEmpty()
	{
		bucket = new SplitBucket(new HashSet<Driver>());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSplitBucketNullElement()
	{
		drivers = new HashSet<Driver>();
		Driver d = null;
		drivers.add(d);
		bucket = new SplitBucket(drivers);
	}

	@Test
	public void testAdd()
	{
		int old = bucket.size();
		bucket.add(new Driver(8999));
		assertEquals(old + 1, bucket.size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddNull()
	{
		Driver d = null;
		bucket.add(d);
	}

	@Test
	public void testAddIdentical()
	{
		Driver first = new Driver(8999);
		first.setNames("Test", "tester");
		bucket.add(first);
		Driver second = new Driver(8999);
		second.setNames("Test", "tester");
		assertFalse(bucket.add(second));
	}

	@Test
	public void testAvgIrating()
	{
		int total = 0;

		for (Driver d : drivers)
		{
			total += d.getiRating();
		}

		int expected = total / drivers.size();

		assertEquals(expected, bucket.avgIrating());
	}

}
