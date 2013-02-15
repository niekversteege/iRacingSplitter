package nl.niek.iracingsplit.driver.csv;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.List;

import nl.niek.iracingsplit.driver.Driver;

import org.junit.Before;
import org.junit.Test;

public class CSVDriverBuilderTest
{
	private static final String	RESULTFILE	= "src/test/resources/eventresult_7490894.csv";
	private static final String	TEXTFILE	= "/src/test/resources/notacsv.txt";
	private static final String	TOOLARGEFILE	= "/src/test/resources/toolargefile";
	private CSVDriverBuilder	builder;

	@Before
	public void setUp() throws Exception
	{
		builder = new CSVDriverBuilder(new File(RESULTFILE));
	}

	@Test
	public void testCSVDriverBuilder()
	{
		List<Driver> drivers = builder.getDrivers();

		assertNotNull(drivers);
		assertFalse(drivers.isEmpty());
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
