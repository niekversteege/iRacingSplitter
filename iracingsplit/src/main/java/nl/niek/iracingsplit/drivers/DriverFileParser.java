package nl.niek.iracingsplit.drivers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class DriverFileParser
{
	private static final int	MAX_SIZE		= 4096;

	private static final int	DRIVER_SEGMENTS	= 3;

	private static final int	FIRSTNAME		= 0;

	private static final int	LASTNAME		= 1;

	private static final int	IRATING			= 2;

	private final Logger		log				= Logger.getLogger(getClass()
														.getName());

	private File				fileToScan;

	private List<Driver>		allDrivers;

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

	private void parseToAllDrivers()
	{
		String fileContents = readFile();

		String[] driverStrings = fileContents.split(",");

		allDrivers.addAll(createDrivers(driverStrings));
	}

	private List<Driver> createDrivers(String[] driverStrings)
	{
		List<Driver> drivers = new ArrayList<Driver>();

		for (String s : driverStrings)
		{
			String[] driverSegments = s.split(".");

			if (driverSegments.length == DRIVER_SEGMENTS)
			{
				Driver newDriver = makeDriver(driverSegments);

				if (newDriver != null)
				{
					drivers.add(newDriver);
				}
			}
		}

		return drivers;
	}

	private Driver makeDriver(String[] driverSegments)
	{
		Driver newDriver = null;

		if (driverSegments[IRATING].matches(".*\\d.*"))
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
}