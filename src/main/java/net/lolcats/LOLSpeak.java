package net.lolcats;

import java.util.ResourceBundle;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Translates English to LOLSpeak.  Based on lolspeak Ruby Gem by Dave Dribin.
 *
 * @author John Lindal
 * @see http://www.dribin.org/dave/lolspeak/
 */

public class LOLSpeak
	extends net.languagegame.Translator
{
	private static ResourceBundle	theDictionary;
	private static Pattern[]		theHeuristics;
	private static String[]			theReplacements;

	static
	{
		theDictionary = ResourceBundle.getBundle("net.lolcats.lolspeak");
		theHeuristics = new Pattern[]
		{
			Pattern.compile("(?:s+|t)ion(s?)$"),
			Pattern.compile("ed$"),
			Pattern.compile("ing$"),
			Pattern.compile("ss$"),
			Pattern.compile("er$"),
			Pattern.compile("ous$"),
			Pattern.compile("s$")
		};

		theReplacements = new String[]
		{
			"shun$1",
			"d",
			"in",
			"s",
			"r",
			"us",
			"z"
		};
	}

	public LOLSpeak()
	{
	}

	/**
	 * Translates single word from English to LOLSpeak.
	 * @param word
	 * @return		LOLSpeak
	 */
	public String translateWord(
		String word)
	{
		String lolWord;
		try
		{
			lolWord = theDictionary.getString(word.toLowerCase());
		}
		catch (java.util.MissingResourceException ex)
		{
			lolWord = word.toLowerCase();
			for (int i=0; i<theHeuristics.length; i++)
			{
				Matcher m = theHeuristics[i].matcher(lolWord);
				if (m.find())
				{
					lolWord = m.replaceFirst(theReplacements[i]);
					break;
				}
			}
		}

		return lolWord;
	}
}
