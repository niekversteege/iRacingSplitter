package nl.niek.iracingsplit.splitter.bucket;

import java.util.ArrayList;
import java.util.List;

import nl.niek.iracingsplit.driver.Driver;

/**
 * This class represents a list of drivers in a split. These buckets are created
 * and filled by the splitter class.
 * 
 * @author Niek
 * 
 */
public class SplitBucket
{
	private List<Driver>	drivers;

	public SplitBucket()
	{
		drivers = new ArrayList<Driver>();
	}

	/**
	 * Initialize a bucket with a collection of drivers.
	 * 
	 * @param drivers
	 */
	public SplitBucket(List<Driver> drivers)
	{
		this();

		if (drivers != null)
		{
			if (drivers.isEmpty())
			{
				throw new IllegalArgumentException(
						"List of drivers cannot be empty.");
			}
			else
			{
				addAll(drivers);
			}
		}
		else
		{
			throw new IllegalArgumentException(
					"List of drivers cannot be null.");
		}
	}

	private void addAll(List<Driver> drivers)
	{
		for (Driver d : drivers)
		{
			add(d);
		}
	}

	/**
	 * Add a new driver to the bucket. Must be unique.
	 * 
	 * @param driver
	 * 
	 * @return
	 */
	public boolean add(final Driver driver)
	{
		if (driver != null)
		{
			boolean success = false;

			if (!drivers.contains(driver))
			{
				success = drivers.add(driver);
			}

			return success;
		}

		throw new IllegalArgumentException("Driver cannot be null.");
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
