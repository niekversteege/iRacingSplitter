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
	private String	firstName;
	private String	lastName;

	public Driver(int iRating)
	{
		this.iRating = iRating;
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

	public final void setFirstName(String firstName)
	{
		if (firstName == null || firstName.isEmpty())
		{
			throw new IllegalArgumentException(
					"First name cannot be null or empty.");
		}
		else
		{
			this.firstName = firstName;
		}
	}

	public final void setLastName(String lastName)
	{
		if (lastName == null || firstName.isEmpty())
		{
			throw new IllegalArgumentException(
					"Last name cannot be null or empty.");
		}
		else
		{
			this.lastName = lastName;
		}
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

	public void setNames(String firstName, String lastName)
	{
		setFirstName(firstName);
		setLastName(lastName);
	}
}
