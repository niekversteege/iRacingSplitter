package nl.niek.iracingsplit.splitter.bucket;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import nl.niek.iracingsplit.drivers.Driver;

/**
 * This class represents a list of drivers in a split. These buckets are created
 * and filled by the splitter class. This class essentially wraps a Set.
 * 
 * @author Niek
 * 
 */
public class SplitBucket
{
	private Set<Driver>	drivers;

	public SplitBucket()
	{
		drivers = new HashSet<Driver>();
	}

	/**
	 * Initialize a bucket with a colletion of drivers.
	 * 
	 * @param drivers
	 */
	public SplitBucket(Collection<Driver> drivers)
	{
		this.drivers.addAll(drivers);
	}

	/**
	 * Add a new driver to the bucket. Must be unique. See {@link Set}
	 * 
	 * @param driver
	 * 
	 * @return
	 */
	public boolean add(final Driver driver)
	{
		return this.drivers.add(driver);
	}

	/**
	 * Get the average iRating of all the drivers in the split.
	 * 
	 * @return
	 */
	public final int avgIrating()
	{
		return 0;
	}
}
