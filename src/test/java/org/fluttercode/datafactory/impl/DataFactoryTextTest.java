package org.fluttercode.datafactory.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DataFactoryTextTest {

    private final int ITERATION_COUNT = 100000;
    private DataFactory dataFactory;

    @Before
    public void initTest() {
        dataFactory = new DataFactory();
        dataFactory.randomize(73438);
    }

    @Test
    public void shouldReturnRandomWordsOfVariedLength() {
        for (int i = 0; i < ITERATION_COUNT; i++) {
            int maxLength = dataFactory.getNumberUpTo(12);

            String word = dataFactory.getRandomWord(maxLength, false);
            Assert.assertTrue("Wrong size word", word.length() <= maxLength);
        }
    }

    @Test
    public void shouldReturnRandomWordsOfSpecificLength() {
        for (int i = 0; i < ITERATION_COUNT; i++) {
            int maxLength = dataFactory.getNumberUpTo(12);

            String word = dataFactory.getRandomWord(maxLength, true);
            Assert.assertTrue("Wrong size word", word.length() == maxLength);
        }
    }

    @Test
    public void shouldReturnRandomWordsOfSpecificLength2() {
        for (int i = 0; i < ITERATION_COUNT; i++) {
            int maxLength = dataFactory.getNumberUpTo(12);

            String word = dataFactory.getRandomWord(maxLength, true);
            Assert.assertTrue("Wrong size word", word.length() == maxLength);
        }
    }

    @Test
    public void shouldReturnTextOfSpecificLength() {
        for (int i = 0; i < ITERATION_COUNT; i++) {
            int len = dataFactory.getNumberUpTo(40);
            String text = dataFactory.getRandomText(len);
            Assert.assertNotNull(text);
            Assert.assertTrue(String.format(
                    "Length does not match (%d, expected %d) '%s' ",
                    text.length(), len, text), len == text.length());

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

    @Test
    public void shouldReturnRandomWordsUpToLength() {
        for (int i = 0; i < ITERATION_COUNT; i++) {
            int maxLength = dataFactory.getNumberUpTo(30);

            String word = dataFactory.getRandomWord(maxLength, false);
            Assert.assertTrue("Wrong size word", word.length() <= maxLength);
        }

    }

    //Test param checking on randomWord()

    @Test(expected = IllegalArgumentException.class)
    public void shouldErrorOnNegativeLengthForRandomWord() {
        dataFactory.getRandomWord(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldErrorOnNegativeMinLenForRandomWord() {
        dataFactory.getRandomWord(-1, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldErrorOnNegativeMaxLenForRandomWord() {
        dataFactory.getRandomWord(0, -10);
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldErrorOnInvalidSizeLenForRandomWord() {
        dataFactory.getRandomWord(10, 2);
    }


    //Test param checking on randomText()

    @Test(expected = IllegalArgumentException.class)
    public void shouldErrorOnNegativeLengthForRandomText() {
        dataFactory.getRandomText(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldErrorOnNegativeMinLenForRandomText() {
        dataFactory.getRandomText(-1, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldErrorOnNegativeMaxLenForRandomText() {
        dataFactory.getRandomText(0, -10);
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldErrorOnInvalidSizeLenForRandomText() {
        dataFactory.getRandomText(10, 2);
    }


    //Test param checking on randomChars()

    @Test(expected = IllegalArgumentException.class)
    public void shouldErrorOnNegativeLengthForRandomChars() {
        dataFactory.getRandomChars(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldErrorOnNegativeMinLenForRandomChars() {
        dataFactory.getRandomChars(-1, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldErrorOnNegativeMaxLenForRandomChars() {
        dataFactory.getRandomChars(0, -10);
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldErrorOnInvalidSizeLenForRandomChars() {
        dataFactory.getRandomChars(10, 2);
    }
}
