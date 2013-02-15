package nl.niek.iracingsplit.driver;

/**
 * Representation of a driver with names and iRating. Can only be created
 * through the parser/factory.
 * 
 * @author Niek
 * 
 */
public class Driver implements Comparable<Driver>
{

	private int		iRating;
	private String	name;

	public Driver(int iRating)
	{
		this.iRating = iRating;
	}

	public final int getiRating()
	{
		return iRating;
	}

	public final String getName()
	{
		return name;
	}

	public final void setName(String name)
	{
		if (name == null || name.isEmpty())
		{
			throw new IllegalArgumentException("Name cannot be null or empty.");
		}
		else
		{
			this.name = name;
		}
	}

	@Override
	public boolean equals(Object obj)
	{
		boolean equal = false;

		if (obj instanceof Driver)
		{
			Driver someDriver = (Driver) obj;
			String otherNAme = someDriver.getName();
			int otherIRating = someDriver.getiRating();

			if (name != null && otherNAme != null)
			{
				equal = name.equals(otherNAme) && iRating == otherIRating;
			}
		}

		return equal;
	}

	@Override
	public int compareTo(Driver o)
	{
		int otherIrating = o.getiRating();
		int retVal = 0;

		if (iRating == otherIrating)
		{
			retVal = 0;
		}
		else if (iRating < otherIrating)
		{
			retVal = -1;
		}
		else if (iRating > otherIrating)
		{
			retVal = 1;
		}

		return retVal;
	}

	@Override
	public String toString()
	{
		return name + "." + iRating;
	}
}
