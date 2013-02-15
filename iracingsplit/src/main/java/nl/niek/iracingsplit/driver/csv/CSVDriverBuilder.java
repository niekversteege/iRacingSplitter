package nl.niek.iracingsplit.driver.csv;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
	private final Logger			log					= Logger.getLogger(getClass());

	private List<File>				csvFiles;

	private static final String[]	IRACING_CSV_HEADER	= { "Fin Pos",
			"Car ID", "Car", "Car Class ID", "Car Class", "Custid", "Driver",
			"Start Pos", "Car #", "Out ID", "Out", "Interval", "Laps Led",
			"Average Lap Time", "Fastest Lap Time", "Fast Lap#", "Laps Comp",
			"Inc", "Pts", "Club Pts", "Div", "Club ID", "Club", "Old iRating",
			"New iRating", "Old License Level", "Old License Sub-Level",
			"New License Level", "New License Sub-Level", "Series Name" };

	public CSVDriverBuilder(File csvFile)
	{
		log.info("Attempting to build drivers from file:");
		log.info(csvFile.getAbsolutePath());

		validateFiles(csvFile);
	}

	public CSVDriverBuilder(List<File> csvFiles)
	{
		log.info("Attempting to build drivers from " + csvFiles.size()
				+ " files.");

		validateFiles(csvFiles);
	}

	private void validateFiles(File csvFile)
	{
		List<File> files = new ArrayList<>();
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
	}

	@Override
	public List<Driver> getDrivers()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
