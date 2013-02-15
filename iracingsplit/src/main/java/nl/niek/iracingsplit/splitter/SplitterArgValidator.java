package nl.niek.iracingsplit.splitter;

public class SplitterArgValidator
{
	private static final int	MAX_IRATING_TRESHOLD	= 100;

	private static final int	MAX_MAX_CARS_ON_TRACK	= 50;

	private static final int	MAX_MIN_DRIVERS			= 10;

	public static void validateArgs(int maxCarsOnTrack, int minDrivers,
			int iratingTreshold)
	{
		validateMaxCarsOnTrack(maxCarsOnTrack);
		validateMinDrivers(minDrivers);
		validateTreshold(iratingTreshold);

		validateMinDriversSmallerThanMaxCars(minDrivers, maxCarsOnTrack);
	}

	private static void validateMinDriversSmallerThanMaxCars(int minDrivers,
			int maxCarsOnTrack)
	{
		if (minDrivers > maxCarsOnTrack)
		{
			throw new IllegalArgumentException(
					"Min drivers must be smaller than max. cars on track.");
		}
	}

	private static void validateMaxCarsOnTrack(final int maxCarsOnTrack)
	{
		if (maxCarsOnTrack > MAX_MAX_CARS_ON_TRACK)
		{
			throw new IllegalArgumentException(
					"Max cars on track too high. Max. 100.");
		}
		else if (isNegative(maxCarsOnTrack))
		{
			throw new IllegalArgumentException(
					"Max cars on track cannot be negative.");
		}
	}

	private static void validateMinDrivers(final int minDrivers)
	{
		if (minDrivers > MAX_MIN_DRIVERS)
		{
			throw new IllegalArgumentException("Min drivers too high. Max. .");
		}
		else if (isNegative(minDrivers))
		{
			throw new IllegalArgumentException(
					"Min drivers cannot be negative.");
		}
	}

	private static void validateTreshold(final int iratingTreshold)
	{
		if (iratingTreshold > MAX_IRATING_TRESHOLD)
		{
			throw new IllegalArgumentException(
					"iRating treshold too high. Max. 100.");
		}
		else if (isNegative(iratingTreshold))
		{
			throw new IllegalArgumentException(
					"iRating treshold cannot be negative.");
		}
	}

	private static boolean isNegative(final int number)
	{
		return number < 0;
	}
}
