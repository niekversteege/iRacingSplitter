package nl.niek.iracingsplit.driver.csv;

import java.io.File;
import java.util.List;

import nl.niek.iracingsplit.driver.Driver;
import nl.niek.iracingsplit.driver.IDriverBuilder;

import org.apache.log4j.Logger;

public class CSVDriverBuilder implements IDriverBuilder
{
	private final Logger log = Logger.getLogger(getClass());
	
	public CSVDriverBuilder(File file)
	{
		log.info("Attempting to build drivers from file:");
		log.info(file.getAbsolutePath());
	}
	
	@Override
	public List<Driver> getDrivers()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
