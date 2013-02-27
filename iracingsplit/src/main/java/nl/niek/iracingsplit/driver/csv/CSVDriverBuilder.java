package nl.niek.iracingsplit.driver.csv;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nl.niek.iracingsplit.driver.Driver;
import nl.niek.iracingsplit.driver.IDriverBuilder;
import nl.niek.iracingsplit.util.FileUtil;

import org.apache.log4j.Logger;

/**
 * Parse an iRacing result CSV file into drivers.
 * 
 * @author Niek
 * 
 */
public class CSVDriverBuilder implements IDriverBuilder
{
	private static final String	IRACING_HEADER_OLDIRATING	= "Old iRating";

	private static final String	IRACING_HEADER_DRIVERNAME	= "Driver";

	private final Logger		log							= Logger.getLogger(getClass());

	private List<File>			csvFiles;

	private Map<String, String>	columnMapping;

	private CSVDriverBuilder()
	{
		columnMapping = new HashMap<String, String>();

		columnMapping.put(IRACING_HEADER_DRIVERNAME, "name");
		columnMapping.put(IRACING_HEADER_OLDIRATING, "iRating");
		
		csvFiles = new ArrayList<File>();
	}

	public CSVDriverBuilder(File csvFile)
	{
		this();

		log.info("Constructing CSVDriverBuilder for file:");
		log.info(csvFile.getAbsolutePath());

		validateFiles(csvFile);
	}

	public CSVDriverBuilder(List<File> csvFiles)
	{
		this();

		log.info("Constructing CSVDriverBuilder for " + csvFiles.size()
				+ " files.");

		validateFiles(csvFiles);
	}

	private void validateFiles(File csvFile)
	{
		List<File> files = new ArrayList<File>();
		files.add(csvFile);
		validateFiles(files);
	}

	private void validateFiles(List<File> csvFiles)
	{
		if (csvFiles == null)
		{
			throw new IllegalArgumentException("List of files is null.");
		}

		if (csvFiles.isEmpty())
		{
			throw new IllegalArgumentException("List of files is empty.");
		}

		for (File f : csvFiles)
		{
			if (!FileUtil.isCsvFile(f))
			{
				throw new IllegalArgumentException(
						"List of files contains non-csv file.");
			}
		}
		
		this.csvFiles.addAll(csvFiles);
	}

	@Override
	public List<Driver> getDrivers()
	{
		List<Driver> drivers = new ArrayList<Driver>();

		for (File csv : csvFiles)
		{
			
		}
		
		return drivers;
	}
}
