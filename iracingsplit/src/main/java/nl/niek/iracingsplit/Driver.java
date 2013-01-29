package nl.niek.iracingsplit;

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
	private String	firstName;
	private String	lastName;

	public Driver(String firstName, String lastName, int iRating)
	{
		if (firstName == null || firstName.isEmpty())
		{
			throw new IllegalArgumentException(
					"First name cannot be null or empty.");
		}
		if (lastName == null || firstName.isEmpty())
		{
			throw new IllegalArgumentException(
					"Last name cannot be null or empty.");
		}

		this.iRating = iRating;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public final int getiRating()
	{
		return iRating;
	}

	public final String getFirstName()
	{
		return firstName;
	}

	public final String getLastName()
	{
		return lastName;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof Driver)
		{
			Driver someDriver = (Driver) obj;
			String otherFirstName = someDriver.getFirstName();
			String otherLastName = someDriver.getLastName();
			int otherIRating = someDriver.getiRating();

			return firstName.equals(otherFirstName)
					&& lastName.equals(otherLastName)
					&& iRating == otherIRating;
		}

		return false;
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
}
