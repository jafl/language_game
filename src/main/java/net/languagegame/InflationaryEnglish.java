package net.languagegame;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Enumeration;

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
	private static List<Pattern>	thePatterns;
	private static List<String>		theReplacements;

	static
	{
		// basic list must be done in order, so cannot be stored in resource bundle

		thePatterns = new ArrayList<Pattern>();
		Collections.addAll(thePatterns,
			Pattern.compile("ten"),
			Pattern.compile("nine"),
			Pattern.compile("eight|ate"),
			Pattern.compile("seven"),
			Pattern.compile("six|sics"),
			Pattern.compile("five"),
			Pattern.compile("four|fore?"),
			Pattern.compile("three"),
			Pattern.compile("two|too|\\bto\\b"),
			Pattern.compile("one|won"),

			Pattern.compile("twice"),
			Pattern.compile("once"));

		theReplacements = new ArrayList<String>();
		Collections.addAll(theReplacements,
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
			"twice");

		ResourceBundle bundle    = ResourceBundle.getBundle("net.languagegame.inflationary_english");
		Enumeration<String> keys = bundle.getKeys();
		while (keys.hasMoreElements())
		{
			String key = keys.nextElement();
			thePatterns.add(Pattern.compile(key));
			theReplacements.add(bundle.getString(key));
		}
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
		for (int i=0; i<thePatterns.size(); i++)
		{
			text = thePatterns.get(i).matcher(text).replaceAll(theReplacements.get(i));
		}

		return text;
	}

	/**
	 * Inflates single English word.
	 * @param word
	 * @return		Inflationary English
	 */
	public String translateWord(
		String word)
	{
		return translate(word);
	}
}
