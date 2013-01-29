package nl.niek.iracingsplit.splitter.bucket;

import java.util.HashSet;
import java.util.Set;

import nl.niek.iracingsplit.Driver;

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
	 * Initialize a bucket with a collection of drivers.
	 * 
	 * @param drivers
	 */
	public SplitBucket(Set<Driver> drivers)
	{
		this();

		if (drivers == null)
		{
			throw new IllegalArgumentException(
					"List of drivers cannot be null.");
		}

		if (drivers.isEmpty())
		{
			throw new IllegalArgumentException(
					"List of drivers cannot be empty.");
		}

		addAll(drivers);
	}

	private void addAll(Set<Driver> drivers)
	{
		for (Driver d : drivers)
		{
			add(d);
		}
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
		if (driver == null)
		{
			throw new IllegalArgumentException("Driver cannot be null.");
		}

		return this.drivers.add(driver);
	}

	/**
	 * Get the average iRating of all the drivers in the split.
	 * 
	 * @return
	 */
	public final int avgIrating()
	{
		int avgIrating = 0;
		if (!drivers.isEmpty())
		{
			int total = 0;

			for (Driver d : drivers)
			{
				total += d.getiRating();
			}

			avgIrating = total / drivers.size();
		}
		return avgIrating;
	}

	public final int size()
	{
		return drivers.size();
	}

	public boolean isEmpty()
	{
		return drivers.isEmpty();
	}
}
