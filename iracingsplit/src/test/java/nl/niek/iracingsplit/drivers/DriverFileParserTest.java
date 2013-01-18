package nl.niek.iracingsplit.drivers;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.junit.Before;
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
	public void testDriverFileParserNullFile()
	{
		parser = new DriverFileParser(null);
	}

	@Test
	public void testGetAllDrivers()
	{
		List<Driver> result = parser.getAllDrivers();

		assertEquals(2, result.size());
		assertEquals(new Driver("Niek", "Versteege", 4686), result.get(0));
		assertEquals(new Driver("Roderic", "Kreunen", 4004), result.get(1));
	}

	@Test
	public void testCreateDrivers()
	{
		
	}
	
	@Test
	public void testCreateDriversNullArg()
	{
		
	}
	
	@Test
	public void testCreateDriversTooLongArg()
	{
		
	}
	
	@Test
	public void testCreateDriversTooBigArg()
	{
		
	}
	
	@Test
	public void testMakeDriver()
	{
		
	}
	
	@Test
	public void testMakeDriverNullArg()
	{
		
	}
	
	@Test
	public void testMakeDriverTooLongArg()
	{
		
	}
	
	@Test
	public void testMakeDriverTooShortArg()
	{
		
	}
}
