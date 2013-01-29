package nl.niek.iracingsplit.driver.factory.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import nl.niek.iracingsplit.driver.Driver;
import nl.niek.iracingsplit.driver.factory.IDriverBuilder;

import org.apache.log4j.Logger;

/**
 * Parse a file of drivers separated by , into a list of drivers. I don't know
 * why I made this since it isn't really that useful. Especially since it
 * doesn't work =D.
 * 
 * @author Niek
 * 
 */
public class DriverFileParser implements IDriverBuilder
{
	private static final String	DRIVER_SPLIT_TOKEN		= ",";

	private static final String	DRIVERINFO_SPLIT_TOKEN	= ".";

	private static final String	NUMBER_REGEX			= ".*\\d.*";

	private static final int	MAX_SIZE				= 4096;

	private static final int	DRIVER_SEGMENTS			= 3;

	private static final int	FIRSTNAME				= 0;

	private static final int	LASTNAME				= 1;

	private static final int	IRATING					= 2;

	private final Logger		log						= Logger.getLogger(getClass()
																.getName());

	private File				fileToScan;

	private List<Driver>		allDrivers;

	@Deprecated
	public DriverFileParser(File fileToScan)
	{
		if (fileToScan == null)
		{
			throw new IllegalArgumentException("File can not be null.");
		}

		allDrivers = new ArrayList<Driver>();
		this.fileToScan = fileToScan;
	}

	public List<Driver> getAllDrivers()
	{
		if (allDrivers.isEmpty())
		{
			parseToAllDrivers();
		}

		return allDrivers;
	}

	protected void parseToAllDrivers()
	{
		String fileContents = readFile();

		String[] driverStrings = fileContents.split(DRIVER_SPLIT_TOKEN);

		allDrivers.addAll(createDrivers(driverStrings));
	}

	protected List<Driver> createDrivers(String[] driverStrings)
	{
		List<Driver> drivers = new ArrayList<Driver>();

		for (String s : driverStrings)
		{
			String[] driverSegments = s.split(DRIVERINFO_SPLIT_TOKEN);

			if (driverSegments.length == DRIVER_SEGMENTS)
			{
				Driver newDriver = makeDriver(driverSegments);

				if (newDriver != null)
				{
					drivers.add(newDriver);
				}
			}
			else
			{
				log.warn("Incorrect formatting found for driver: found "
						+ driverSegments.length + " elements. Require "
						+ DRIVER_SEGMENTS);
			}
		}

		return drivers;
	}

	protected Driver makeDriver(String[] driverSegments)
	{
		Driver newDriver = null;

		if (driverSegments[IRATING].matches(NUMBER_REGEX))
		{
			int irating = Integer.parseInt(driverSegments[IRATING]);
			String firstName = driverSegments[FIRSTNAME];
			String lastName = driverSegments[LASTNAME];

			newDriver = new Driver(firstName, lastName, irating);
		}

		return newDriver;
	}

	private String readFile()
	{
		byte[] buffer = new byte[MAX_SIZE];

		try
		{
			FileInputStream stream = new FileInputStream(fileToScan);

			stream.read(buffer);
			stream.close();
		}
		catch (IOException e)
		{
			log.error("Error reading file.", e);
		}

		return new String(buffer);
	}

	@Override
	public Set<Driver> getDrivers()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
