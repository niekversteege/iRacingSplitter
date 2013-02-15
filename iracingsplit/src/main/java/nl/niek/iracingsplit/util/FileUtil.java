package nl.niek.iracingsplit.util;

import java.io.File;

public class FileUtil
{
	private static final String	CSV	= "csv";

	public static boolean isCsvFile(File file)
	{
		return getExtension(file).equals(CSV);
	}

	public static String getExtension(File file)
	{
		String extension = "";
		String fileName = file.getName();

		int exensionDotPos = fileName.lastIndexOf('.');
		int lastSlash = Math.max(fileName.lastIndexOf('/'),
				fileName.lastIndexOf('\\'));

		if (exensionDotPos > lastSlash)
		{
			extension = fileName.substring(exensionDotPos + 1);
		}

		return extension;
	}
}
