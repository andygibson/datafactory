package org.fluttercode.datafactory;

/*
 * Copyright 2011, Andrew M Gibson
 *
 * www.andygibson.net
 *
 * This file is part of DataFactory
 *
 * DataValve is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * DataFactory is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with DataFactory.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

public interface AddressDataValues {

    /**
     * @return Array of street address
     */
    String[] getStreetNames();

    /**
     * @return Array of cities
     */
    String[] getCities();

    /**
     * Returns a list of address suffixes such as "Lane", "Drive", "Parkway"
     *
     * @return Array of address suffixes
     */
    String[] getAddressSuffixes();

    /**
     * Returns a list of countries
     *
     * @return Array of countries
     */
    String[] getCountries();

    /**
     * Returns a list of country abbreviations
     *
     * @return Array of country abbreviations
     */
    String[] getCountriesShort();
}
