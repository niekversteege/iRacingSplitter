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

	private int		irating;
	private String	name;

	public Driver()
	{

	}

	public Driver(int iRating, String name)
	{
		this.irating = iRating;
		this.name = name;
	}

	public final String getName()
	{
		return name;
	}

	public final int getIrating()
	{
		return irating;
	}

	public final void setIrating(int irating)
	{
		this.irating = irating;
	}

	public final void setName(String name)
	{
		this.name = name;
	}

	@Override
	public boolean equals(Object obj)
	{
		boolean equal = false;

		if (obj instanceof Driver)
		{
			Driver someDriver = (Driver) obj;
			String otherNAme = someDriver.getName();
			int otherIRating = someDriver.getIrating();

			if (name != null && otherNAme != null)
			{
				equal = name.equals(otherNAme) && irating == otherIRating;
			}
		}

		return equal;
	}

	@Override
	public int compareTo(Driver o)
	{
		int otherIrating = o.getIrating();
		int retVal = 0;

		if (irating == otherIrating)
		{
			retVal = 0;
		}
		else if (irating < otherIrating)
		{
			retVal = -1;
		}
		else if (irating > otherIrating)
		{
			retVal = 1;
		}

		return retVal;
	}

	@Override
	public String toString()
	{
		return name + "." + irating;
	}
}
