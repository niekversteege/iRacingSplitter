package nl.niek.iracingsplit.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class FileUtilTest
{
	private static final String	RESULTFILE1	= "src/test/resources/eventresult_7490894.csv";
	private static final String	TEXTFILE	= "/src/test/resources/notacsv.txt";
	private static final String	NOEXTENSION	= "/src/test/resources/toolargefile";
	
	private File	csvFile;
	private File	notCsvFile;
	private File	noExt;

	@Before
	public void setUp() throws Exception
	{
		csvFile = new File(RESULTFILE1);
		notCsvFile = new File(TEXTFILE);
		noExt = new File(NOEXTENSION);
	}

	@Test
	public void testIsCsv()
	{
		assertTrue(FileUtil.isCsvFile(csvFile));
	}

	@Test
	public void testNotCsvTxt()
	{
		assertFalse(FileUtil.isCsvFile(notCsvFile));
	}
	
	@Test
	public void testNotCsvNoExt()
	{
		assertFalse(FileUtil.isCsvFile(noExt));
	}
}
