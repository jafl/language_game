package net.languagegame;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Base class for translators that operate on each word separately.
 *
 * @author John Lindal
 * @see http://en.wikipedia.org/wiki/Pig_latin
 */

public abstract class Translator
{
	private static final Pattern	theWordPattern = Pattern.compile("[\\w']+");

	public Translator()
	{
	}

	/**
	 * Translates text from English to whatever.
	 * @param text	whitespace-separated words
	 * @return		translated text
	 */
	public String translate(
		String text)
	{
		StringBuilder buf = new StringBuilder();

		Matcher m = theWordPattern.matcher(text);
		int offset1 = 0, offset2 = 0;
		while (offset1 < text.length())
		{
			if (!m.find(offset1))
			{
				buf.append(text.substring(offset1, text.length()));
				break;
			}
			offset2 = m.start();

			if (offset2 > offset1)
			{
				buf.append(text.substring(offset1, offset2));
			}
			buf.append(translateWord(text.substring(m.start(), m.end())));

			offset1 = m.end();
		}

		return buf.toString();
	}

	/**
	 * Translates single word from English to whatever.
	 * @param word
	 * @return		translated word
	 */
	abstract public String translateWord(String word);
}
