package org.fluttercode.datafactory.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DataFactoryTextTest {

	private DataFactory dataFactory;
	private final int ITERATION_COUNT = 100000;

	@Before
	public void initTest() {
		dataFactory = new DataFactory();
		dataFactory.randomize(73438);
	}

	@Test
	public void shouldReturnRandomWordsOfVariedLength() {
		for (int i = 0; i < ITERATION_COUNT; i++) {			
			int maxLength = dataFactory.getNumberUpTo(12);

			String word = dataFactory.getRandomWord(maxLength,false);
			Assert.assertTrue("Wrong size word",word.length() <= maxLength);
		}

	}
	
	@Test
	public void shouldReturnRandomWordsOfSpecificLength() {
		for (int i = 0; i < ITERATION_COUNT; i++) {			
			int maxLength = dataFactory.getNumberUpTo(12);

			String word = dataFactory.getRandomWord(maxLength,true);
			Assert.assertTrue("Wrong size word",word.length() == maxLength);
		}

	}
	

	@Test
	public void shouldReturnTextOfSpecificLength() {
		for (int i = 0; i < ITERATION_COUNT; i++) {
			int len = dataFactory.getNumberUpTo(40);
			String text = dataFactory.getRandomText(len, len);
			Assert.assertNotNull(text);
			Assert.assertTrue(String.format("Length does not match (%d, expected %d) '%s' ",text.length(),len,text),len==text.length());
						
		}
	}
	
	@Test
	public void shouldReturnTextWithinBoundedLengths() {
		for (int i = 0; i < ITERATION_COUNT; i++) {
			int minLen = 10 + dataFactory.getNumberUpTo(20);
			int maxLen = minLen + dataFactory.getNumberUpTo(10);

			String text = dataFactory.getRandomText(minLen, maxLen);
		
			Assert.assertNotNull(text);

			String msg = String
					.format("Length (%d) is less than expected minimum (%d) for iteration %d - text = '%s'",
							text.length(), minLen, i, text);
			Assert.assertTrue(msg, minLen <= text.length());

			msg = String
					.format("Length (%d) is more than expected (%d) for iteration %d - text = %s",
							text.length(), maxLen, i, text);
			Assert.assertTrue(msg, maxLen >= text.length());

		}
	}
}
