package nl.niek.iracingsplit.driver.csv;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import nl.niek.iracingsplit.driver.Driver;

import org.junit.Before;
import org.junit.Test;

public class CSVDriverBuilderTest
{
	private static final String	RESULTFILE1	= "src/test/resources/eventresult_7490894.csv";
	private static final String	RESULTFILE2	= "src/test/resources/eventresult_7490895.csv";
	private static final String	RESULTFILE3	= "src/test/resources/eventresult_7490896.csv";
	
	private static final String	TEXTFILE	= "/src/test/resources/notacsv.txt";
	private static final String	TOOLARGEFILE	= "/src/test/resources/toolargefile";
	
	private CSVDriverBuilder	builder;

	@Before
	public void setUp() throws Exception
	{
		builder = new CSVDriverBuilder(new File(RESULTFILE1));
	}

	@Test
	public void testCSVDriverBuilder()
	{
		List<Driver> drivers = builder.getDrivers();

		assertEquals(31, drivers.size());
	}
	
	@Test
	public void testCSVDriverBuilderList()
	{
		List<File> files = new ArrayList<>();
		
		files.add(new File(RESULTFILE1));
		files.add(new File(RESULTFILE2));
		files.add(new File(RESULTFILE3));
		
		builder = new CSVDriverBuilder(files);
		
		List<Driver> drivers = builder.getDrivers();

		assertEquals(92, drivers.size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCSVDriverBuilderNotCSV()
	{
		builder = new CSVDriverBuilder(new File(TEXTFILE));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCSVDriverBuilderTooLarge()
	{
		builder = new CSVDriverBuilder(new File(TOOLARGEFILE));
	}
}
