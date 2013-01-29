package nl.niek.iracingsplit.driver.factory;

import java.util.Set;

import nl.niek.iracingsplit.driver.Driver;

public interface IDriverBuilder
{
	/**
	 * Make sure implementations of this are instantly filled with data so this
	 * method can be called asap.
	 * 
	 * @return All the drivers parsed from whatever source: dependent on the
	 *         implementation.
	 */
	Set<Driver> getDrivers();
}
