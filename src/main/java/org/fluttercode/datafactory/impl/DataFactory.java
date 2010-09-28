package org.fluttercode.datafactory.impl;

/*
 * Copyright 2010, Andrew M Gibson
 *
 * www.andygibson.net
 *
 * This file is part of DataFactory.
 *
 * DataValve is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * DataValve is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with DataValve.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.fluttercode.datafactory.AddressDataValues;
import org.fluttercode.datafactory.ContentDataValues;
import org.fluttercode.datafactory.NameDataValues;

/**
 * Class that provides a number of methods for generating test data through
 * helper components. These components implement interfaces that provide an
 * interface to accessing the test data. Components can be replaced with other
 * components to allow more suitable data to be used.
 * 
 * @author Andy Gibson
 * 
 */
public final class DataFactory {

	private static Random random = new Random(93285);

	private NameDataValues nameDataValues = new DefaultNameDataValues();
	private AddressDataValues addressDataValues = new DefaultAddressDataValues();
	private ContentDataValues contentDataValues = new DefaultContentDataValues();

	/**
	 * Returns a random item from a list of items.
	 * 
	 * @param <T>
	 *            Item type in the list and to return
	 * @param items
	 *            List of items to choose from
	 * @return Item from the list
	 */
	public <T> T getItem(List<T> items) {
		return getItem(items, 100, null);
	}

	/**
	 * Returns a random item from a list of items or the null depending on the
	 * probability parameter. The probability determines the chance (in %) of
	 * returning an item off the list versus null.
	 * 
	 * @param <T>
	 *            Item type in the list and to return
	 * @param items
	 *            List of items to choose from
	 * @param probability
	 *            chance (in %, 100 being guaranteed) of returning an item from
	 *            the list
	 * @return Item from the list or null if the probability test fails.
	 */
	public <T> T getItem(List<T> items, int probability) {
		return getItem(items, probability, null);
	}

	/**
	 * Returns a random item from a list of items or the defaultItem depending
	 * on the probability parameter. The probability determines the chance (in
	 * %) of returning an item off the list versus the default value.
	 * 
	 * @param <T>
	 *            Item type in the list and to return
	 * @param items
	 *            List of items to choose from
	 * @param probability
	 *            chance (in %, 100 being guaranteed) of returning an item from
	 *            the list
	 * @param defaultItem
	 *            value to return if the probability test fails
	 * @return Item from the list or the default value
	 */
	public <T> T getItem(List<T> items, int probability, T defaultItem) {
		if (items == null) {
			throw new IllegalArgumentException("Item list cannot be null");
		}
		if (items.isEmpty()) {
			throw new IllegalArgumentException("Item list cannot be empty");
		}

		return chance(probability) ? items.get(random.nextInt(items.size()))
				: defaultItem;
	}

	/**
	 * Returns a random item from an array of items
	 * 
	 * @param <T>
	 *            Array item type and the type to return
	 * @param items
	 *            Array of items to choose from
	 * @return Item from the array
	 */
	public <T> T getItem(T[] items) {
		return getItem(items, 100, null);
	}

	/**
	 * Returns a random item from an array of items or null depending on the
	 * probability parameter. The probability determines the chance (in %) of
	 * returning an item from the array versus null.
	 * 
	 * @param <T>
	 *            Array item type and the type to return
	 * @param items
	 *            Array of items to choose from
	 * @param probability
	 *            chance (in %, 100 being guaranteed) of returning an item from
	 *            the array
	 * @return Item from the array or the default value
	 */
	public <T> T getItem(T[] items, int probability) {
		return getItem(items, probability, null);
	}

	/**
	 * Returns a random item from an array of items or the defaultItem depending
	 * on the probability parameter. The probability determines the chance (in
	 * %) of returning an item from the array versus the default value.
	 * 
	 * @param <T>
	 *            Array item type and the type to return
	 * @param items
	 *            Array of items to choose from
	 * @param probability
	 *            chance (in %, 100 being guaranteed) of returning an item from
	 *            the array
	 * @param defaultItem
	 *            value to return if the probability test fails
	 * @return Item from the array or the default value
	 */
	public <T> T getItem(T[] items, int probability, T defaultItem) {
		if (items == null) {
			throw new IllegalArgumentException("Item array cannot be null");
		}
		if (items.length == 0) {
			throw new IllegalArgumentException("Item array cannot be empty");
		}
		return chance(probability) ? items[random.nextInt(items.length)]
				: defaultItem;
	}

	/**
	 * @return A random first name
	 */
	public String getFirstName() {
		return getItem(nameDataValues.getFirstNames());
	}

	public String getName() {
		return getItem(nameDataValues.getFirstNames()) + " "
				+ getItem(nameDataValues.getLastNames());
	}

	/**
	 * @return A random last name
	 */
	public String getLastName() {
		return getItem(nameDataValues.getLastNames());
	}

	/**
	 * @return A random street name
	 */
	public String getStreetName() {
		return getItem(addressDataValues.getStreetNames());
	}

	/**
	 * @return A random street suffix
	 */
	public String getStreetSuffix() {
		return getItem(addressDataValues.getAddressSuffixes());
	}

	/**
	 * Generates a random city value
	 * 
	 * @return City as a string
	 */
	public String getCity() {
		return getItem(addressDataValues.getCities());
	}

	/**
	 * Generates an address value consisting of house number, street name and
	 * street suffix. i.e. <code>543 Larkhill Road</code>
	 * 
	 * @return Address as a string
	 */
	public String getAddress() {
		int num = 404 + random.nextInt(1400);
		return num + " " + getStreetName() + " " + getStreetSuffix();
	}

	/**
	 * Generates line 2 for a street address (usually an Apt. or Suite #).
	 * Returns null if the probabilty test fails.
	 * 
	 * @param probability
	 *            Chance as % of have a value returned instead of null.
	 * @return Street address line two or null if the probability test fails
	 */
	public String getAddressLine2(int probability) {
		return getAddressLine2(probability, null);
	}

	/**
	 * Generates line 2 for a street address (usually an Apt. or Suite #).
	 * Returns default value if the probabilty test fails.
	 * 
	 * @param probability
	 *            Chance as % of have a value returned instead of null.
	 * @param defaultValue
	 *            Value to return if the probability test fails.
	 * @return Street address line two or null if the probability test fails
	 */
	public String getAddressLine2(int probability, String defaultValue) {
		return chance(probability) ? getAddressLine2() : defaultValue;
	}

	/**
	 * Generates line 2 for a street address (usually an Apt. or Suite #).
	 * Returns default value if the probabilty test fails.
	 * 
	 * @return Street address line 2
	 */
	public String getAddressLine2() {
		int test = random.nextInt(100);
		if (test < 50) {
			return "Apt #" + 100 + random.nextInt(1000);
		} else {
			return "Suite #" + 100 + random.nextInt(1000);
		}
	}

	/**
	 * Creates a random birthdate within the range of 1955 to 1985
	 * 
	 * @return Date representing a birthdate
	 */
	public Date getBirthDate() {
		Date base = new Date(0);
		return getDate(base, -365 * 15, 365 * 15);
	}

	/**
	 * Returns a random int value.
	 * 
	 * @return random number
	 */
	public int getNumber() {
		return getNumberBetween(Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/**
	 * Returns a random number between 0 and max
	 * 
	 * @param max
	 *            Maximum value of result
	 * @return random number no more than max
	 */
	public int getNumberUpTo(int max) {
		return getNumberBetween(0, max);
	}

	/**
	 * Returns a number betwen min and max
	 * 
	 * @param min
	 *            minimum value of result
	 * @param max
	 *            maximum value of result
	 * @return Random number within range
	 */
	public int getNumberBetween(int min, int max) {
		return min + random.nextInt(max - min);
	}

	/**
	 * Builds a date from the year, month, day values passed in
	 * 
	 * @param year
	 *            The year of the final {@link Date} result
	 * @param month
	 *            The month of the final {@link Date} result
	 * @param day
	 *            The day of the final {@link Date} result
	 * @return Date representing the passed in values.
	 */
	public Date getDate(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(year, month - 1, day, 0, 0, 0);
		return cal.getTime();
	}

	/**
	 * Returns a random date which is in the range <code>baseData</code> +
	 * <code>minDaysFromData</code> to <code>baseData</code> +
	 * <code>maxDaysFromData</code>.
	 * 
	 * @param baseDate
	 *            Date to start from
	 * @param minDaysFromDate
	 *            minimum number of days from the baseDate the result can be
	 * @param maxDaysFromDate
	 *            maximum number of days from the baseDate the result can be
	 * @return A random date
	 */
	public Date getDate(Date baseDate, int minDaysFromDate, int maxDaysFromDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(baseDate);
		int diff = minDaysFromDate
				+ (random.nextInt(maxDaysFromDate - minDaysFromDate));
		cal.add(Calendar.DATE, diff);
		return cal.getTime();
	}

	/**
	 * Returns a random date between two dates
	 * 
	 * @param minDate
	 *            Minimum date that can be returned
	 * @param maxDate
	 *            Maximum date that can be returned
	 * @return random date between these two dates.
	 */
	public Date getDateBetween(Date minDate, Date maxDate) {
		int seconds = (int) ((maxDate.getTime() - minDate.getTime()) / 1000);
		seconds = random.nextInt(seconds);
		Date result = new Date();
		result.setTime(minDate.getTime() + (seconds * 1000));
		return result;
	}

	/**
	 * Returns a random string of characters of limited length.
	 * 
	 * @param maxLength
	 *            the maximum number of characters in the result
	 * @return a string of random characters
	 */
	public String getRandomText(int maxLength) {
		return getRandomText(maxLength, maxLength >> 1);
	}

	/**
	 * Returns random text
	 * 
	 * @param maxLength
	 * @param minLength
	 * @return
	 */
	public String getRandomText(int maxLength, int minLength) {
		String res = "";
		while (res.length() < minLength) {
			res = res + generateWord() + " ";
		}
		String result = res;
		int count = (maxLength - minLength) >> 3;
		while (res.length() < maxLength && count > 0) {
			result = res;
			res = res + generateWord() + " ";
			count--;
		}
		return result.trim();
	}

	/**
	 * @return a random character
	 */
	public char getRandomChar() {
		return (char) (random.nextInt(26) + 'a');
	}

	/**
	 * Returns a word of a length between 1 and 10 characters.
	 * 
	 * @return A work of max length 10
	 */
	public String generateWord() {
		return getItem(contentDataValues.getWords());
	}

	/**
	 * Generate a random word of length between min and max length. If max-min
	 * len < 0 then a string of length 10 is returned.
	 * 
	 * @param minLen
	 *            minimum length of word
	 * @param maxLen
	 *            maximum length of word
	 * @return random word
	 */
	public String generateWord(int minLen, int maxLen) {
		int len = maxLen - minLen;
		if (len < 0) {
			len = 10;
			minLen = 1;
		}

		len = minLen + random.nextInt(len);

		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			sb.append(getRandomChar());
		}
		return sb.toString();
	}

	/**
	 * 
	 * @param chance
	 *            Chance of a suffix being returned
	 * @return
	 */
	public String getSuffix(int chance) {
		return getItem(nameDataValues.getSuffixes(), chance);
	}

	/**
	 * Return a person prefix or null if the odds are too low.
	 * 
	 * @param chance
	 *            Odds of a prefix being returned
	 * @return Prefix string
	 */
	public String getPrefix(int chance) {
		return getItem(nameDataValues.getPrefixes(), chance);
	}

	/**
	 * Returns a string containing a set of numbers with a fixed number of
	 * digits
	 * 
	 * @param digits
	 *            number of digits in the final number
	 * @return Random number as a string with a fixed length
	 */
	public String getNumberText(int digits) {
		String result = "";
		for (int i = 0; i < digits; i++) {
			result = result + random.nextInt(10);
		}
		return result;
	}

	/**
	 * Generates a random business name by taking a city name and additing a
	 * business onto it.
	 * 
	 * @return A random business name
	 */
	public String getBusinessName() {
		return getCity() + " " + getItem(contentDataValues.getBusinessTypes());
	}

	/**
	 * Generates an email address
	 * 
	 * @return an email address
	 */
	public String getEmailAddress() {
		int test = random.nextInt(100);
		String email = "";
		if (test < 50) {
			// name and initial
			email = getFirstName().charAt(0) + getLastName();
		} else {
			// 2 words
			email = getItem(contentDataValues.getWords())
					+ getItem(contentDataValues.getWords());
		}
		if (random.nextInt(100) > 80) {
			email = email + random.nextInt(100);
		}
		email = email + "@" + getItem(contentDataValues.getEmailHosts()) + "."
				+ getItem(contentDataValues.getTlds());
		return email.toLowerCase();
	}

	/**
	 * Gives you a true/false based on a probability with a random number
	 * generator. Can be used to optionally add elements.
	 * 
	 * <pre>
	 * if (DataFactory.chance(70)) {
	 * 	// 70% chance of this code being executed
	 * }
	 * </pre>
	 * 
	 * @param chance
	 *            % chance of returning true
	 * @return
	 */
	public boolean chance(int chance) {
		return random.nextInt(100) < chance;
	}

	public NameDataValues getNameDataValues() {
		return nameDataValues;
	}

	public void setNameDataValues(NameDataValues nameDataValues) {
		this.nameDataValues = nameDataValues;
	}

	/**
	 * Call randomize with a seed value to reset the random number generator. By
	 * using the same seed over different tests, you will should get the same
	 * results out for the same data generation calls.
	 * 
	 * @param seed
	 *            Seed value to use to generate random numbers
	 */
	public void randomize(int seed) {
		random = new Random(seed);
	}
}
