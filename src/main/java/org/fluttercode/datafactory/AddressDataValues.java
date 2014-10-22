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
     * Returns an array of street addresses.
     *
     * @return array of street addresses
     */
    String[] getStreetNames();

    /**
     * Returns an array of cities.
     *
     * @return array of cities
     */
    String[] getCities();

    /**
     * Returns an array of address suffixes such as "Lane", "Drive", "Parkway".
     *
     * @return array of address suffixes
     */
    String[] getAddressSuffixes();

    /**
     * Returns an array of countries.
     *
     * @return array of countries
     */
    String[] getCountries();

    /**
     * Returns an array of country abbreviations.
     *
     * @return array of country abbreviations
     */
    String[] getCountriesShort();

    /**
     * Returns an array of nationalities.
     *
     * @return array of nationalities
     */
    String[] getNationalities();
}
