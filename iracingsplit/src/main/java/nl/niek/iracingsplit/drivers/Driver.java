package nl.niek.iracingsplit.drivers;

/**
 * Representation of a driver with names and iRating. Can only be created
 * through the parser/factory.
 * 
 * @author Niek
 * 
 */
public class Driver
{

	private int		iRating;
	private String	firstName;
	private String	lastName;

	Driver(String firstName, String lastName, int iRating)
	{
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
}
