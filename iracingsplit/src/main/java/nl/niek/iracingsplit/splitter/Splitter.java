package nl.niek.iracingsplit.splitter;

import java.util.ArrayList;
import java.util.List;

import nl.niek.iracingsplit.driver.Driver;
import nl.niek.iracingsplit.driver.IDriverBuilder;
import nl.niek.iracingsplit.splitter.bucket.SplitBucket;

/**
 * This class does the actual splitting. It looks at the amount of drivers
 * registered and creates and appropriate amount of buckets (driving splits). It
 * will then divide all the drivers correctly into the created splits.
 * 
 * @author Niek
 * 
 */
public class Splitter
{
	private final int	maxCarsOnTrack;
	private final int	minDrivers;
	private final int	iratingTreshold;

	/**
	 * Create a splitter with the correct settings.
	 * 
	 * @param maxCarsOnTrack
	 *            Maximum number of drivers that will fit in a split (number of
	 *            pitstalls).
	 * @param minDrivers
	 *            Minimum number of drivers to make the race official.
	 * @param iratingTreshold
	 *            The percentage (0-100) of the highest iRating in the split
	 *            that is allowed.
	 */
	public Splitter(final int maxCarsOnTrack, final int minDrivers,
			final int iratingTreshold)
	{
		this.maxCarsOnTrack = maxCarsOnTrack;
		this.minDrivers = minDrivers;
		this.iratingTreshold = iratingTreshold;
	}

	/**
	 * Get all the drivers from the given builder and construct a bunch of
	 * racing splits based on the parameters the splitter was initialized with.
	 * 
	 * @param builder
	 *            The source of all the drivers. The getDrivers() method is
	 *            called on it.
	 * @return A list of all splits. If no proper splitting could be achieved
	 *         the list will be empty.
	 */
	public List<SplitBucket> split(IDriverBuilder builder)
	{
		List<SplitBucket> buckets = new ArrayList<SplitBucket>();
		List<Driver> drivers = builder.getDrivers();

		return buckets;
	}
}
