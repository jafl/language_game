package net.languagegame;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Translates English to Victor Borge's Inflationary English.
 *
 * @author John Lindal
 * @see http://en.wikipedia.org/wiki/Inflationary_English#Borge.27s_style
 */

public class InflationaryEnglish
	extends Translator
{
	private static Pattern[]	thePatterns;
	private static String[]	theReplacements;

	static
	{
		thePatterns = new Pattern[]
		{
			Pattern.compile("ten"),
			Pattern.compile("nine"),
			Pattern.compile("eight|ate"),
			Pattern.compile("seven"),
			Pattern.compile("six|sics"),
			Pattern.compile("five"),
			Pattern.compile("four|fore?"),
			Pattern.compile("three"),
			Pattern.compile("two|too"),
			Pattern.compile("one|won"),

			Pattern.compile("twice"),
			Pattern.compile("once")
		};

		theReplacements = new String[]
		{
			"eleven",
			"ten",
			"nine",
			"eight",
			"seven",
			"six",
			"five",
			"four",
			"three",
			"two",

			"thrice",
			"twice"
		};
	}

	public InflationaryEnglish()
	{
	}

	/**
	 * Inflates English.
	 * @param text	whitespace-separated words
	 * @return		Inflationary English
	 */
	@Override
	public String translate(
		String text)
	{
		for (int i=0; i<thePatterns.length; i++)
		{
			text = thePatterns[i].matcher(text).replaceAll(theReplacements[i]);
		}

		return text;
	}

	/**
	 * Inflates single English word.
	 * @param text	word
	 * @return		Inflationary English
	 */
	public String translateWord(
		String word)
	{
		return translate(word);
	}
}
