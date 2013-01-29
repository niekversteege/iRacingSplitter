package nl.niek.iracingsplit.splitter;

import java.util.ArrayList;
import java.util.List;

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
	private final int	MAX_CARS_ON_TRACK;
	private final int	MIN_DRIVERS_FOR_OFFICIAL;
	private final int	IRATING_TRESHOLD;

	/**
	 * Create a splitter with the correct settings.
	 * 
	 * @param maxCarsOnTrack
	 * @param minDrivers
	 * @param iratingTreshold
	 *            The percentage (0-100) of the highest iRating in the split
	 *            that is allowed.
	 */
	public Splitter(final int maxCarsOnTrack, final int minDrivers,
			final int iratingTreshold)
	{
		this.MAX_CARS_ON_TRACK = maxCarsOnTrack;
		this.MIN_DRIVERS_FOR_OFFICIAL = minDrivers;
		this.IRATING_TRESHOLD = iratingTreshold;
	}

	/**
	 * Get all the drivers from the given builder and construct a bunch of
	 * racing splits based on the parameters the splitter was initialized with.
	 * 
	 * @param builder
	 *            The source of all the drivers. The getDrivers() method is
	 *            called on it.
	 * @return
	 */
	public List<SplitBucket> split(IDriverBuilder builder)
	{
		List<SplitBucket> buckets = new ArrayList<SplitBucket>();

		return buckets;
	}
}
