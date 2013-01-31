package nl.niek.iracingsplit.driver;

import java.util.List;


public interface IDriverBuilder
{
	/**
	 * Make sure implementations of this are instantly filled with data so this
	 * method can be called asap.
	 * 
	 * @return All the drivers parsed from whatever source: dependent on the
	 *         implementation.
	 */
	List<Driver> getDrivers();
}
