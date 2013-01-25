package nl.niek.iracingsplit.splitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import nl.niek.iracingsplit.drivers.Driver;
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
	 * 
	 * @param allDrivers
	 *            A list of all the drivers that have signed up for the race.
	 * @return
	 */
	public List<SplitBucket> split(Set<Driver> allDrivers)
	{
		int nrOfDrivers = allDrivers.size();

		List<SplitBucket> buckets = new ArrayList<SplitBucket>();

		if (nrOfDrivers > MAX_CARS_ON_TRACK)
		{
			// TODO: determine how many splits to make (modulo)
			// TODO: use a binary tree?
			// TODO: more cool stuff?
		}
		else
		{
			buckets.add(new SplitBucket(allDrivers));
		}

		return buckets;
	}
}
