package nl.niek.iracingsplit.splitter.bucket;

import java.util.HashSet;
import java.util.Set;

import nl.niek.iracingsplit.drivers.Driver;

/**
 * This class represents a list of drivers in a split. These buckets are created
 * and filled by the splitter class.
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

	public void add(final Driver driver)
	{
		this.drivers.add(driver);
	}
}
