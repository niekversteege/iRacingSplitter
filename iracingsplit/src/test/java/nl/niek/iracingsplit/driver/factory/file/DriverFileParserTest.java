package nl.niek.iracingsplit.driver.factory.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.List;

import nl.niek.iracingsplit.driver.Driver;
import nl.niek.iracingsplit.driver.factory.file.DriverFileParser;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class DriverFileParserTest
{
	DriverFileParser	parser;

	@Before
	public void setUp() throws Exception
	{
		File file = new File(DriverFileParserTest.class.getResource(
				"/driverList").toURI());
		parser = new DriverFileParser(file);
	}

	@Test(expected = IllegalArgumentException.class)
	@Ignore
	public void testDriverFileParserNullFile()
	{
		parser = new DriverFileParser(null);
	}

	@Test
	@Ignore
	public void testGetAllDrivers()
	{
		List<Driver> result = parser.getAllDrivers();

		assertEquals(2, result.size());
		assertEquals(new Driver("Niek", "Versteege", 4686), result.get(0));
		assertEquals(new Driver("Roderic", "Kreunen", 4004), result.get(1));
	}

	@Test
	@Ignore
	public void testCreateDrivers()
	{
		fail("Not yet implemented");
	}
	
	@Test
	@Ignore
	public void testCreateDriversNullArg()
	{
		fail("Not yet implemented");
	}
	
	@Test
	@Ignore
	public void testCreateDriversTooLongArg()
	{
		fail("Not yet implemented");
	}
	
	@Test
	@Ignore
	public void testCreateDriversTooBigArg()
	{
		fail("Not yet implemented");
	}
	
	@Test
	@Ignore
	public void testMakeDriver()
	{
		fail("Not yet implemented");
	}
	
	@Test
	@Ignore
	public void testMakeDriverNullArg()
	{
		fail("Not yet implemented");
	}
	
	@Test
	@Ignore
	public void testMakeDriverTooLongArg()
	{
		fail("Not yet implemented");
	}
	
	@Test
	@Ignore
	public void testMakeDriverTooShortArg()
	{
		fail("Not yet implemented");
	}
}
