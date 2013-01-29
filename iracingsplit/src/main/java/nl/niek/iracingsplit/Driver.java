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
		// TODO Look at name
		// TODO Look at irating
		return super.equals(obj);
	}

	@Override
	public int compareTo(Driver o)
	{
		// TODO: Compare by irating
		return 0;
	}
}
