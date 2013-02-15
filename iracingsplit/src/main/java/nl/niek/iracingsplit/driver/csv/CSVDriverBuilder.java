package nl.niek.iracingsplit.driver.csv;

import java.io.File;
import java.util.List;

import nl.niek.iracingsplit.driver.Driver;
import nl.niek.iracingsplit.driver.IDriverBuilder;

import org.apache.log4j.Logger;

/**
 * Parse an iRacing result CSV file into drivers.
 * 
 * @author Niek
 * 
 */
public class CSVDriverBuilder implements IDriverBuilder
{
	private final Logger	log	= Logger.getLogger(getClass());

	public CSVDriverBuilder(File csvFile)
	{
		log.info("Attempting to build drivers from file:");
		log.info(csvFile.getAbsolutePath());

	}

	public CSVDriverBuilder(List<File> csvFiles)
	{
		log.info("Attempting to build drivers from " + csvFiles.size()
				+ " files.");
	}

	@Override
	public List<Driver> getDrivers()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
