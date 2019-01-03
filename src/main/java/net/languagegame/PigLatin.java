package net.languagegame;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Translates English to Pig Latin.
 *
 * @author John Lindal
 * @see http://en.wikipedia.org/wiki/Pig_latin
 */

public class PigLatin
	extends Translator
{
	private static final Pattern	thePrefixPattern = Pattern.compile("^(qu|[bcdfghjklmnpqrstvwxyz]+)(.+)$");

	public PigLatin()
	{
	}

	/**
	 * Translates single word from English to Pig Latin.
	 * @param word
	 * @return		Pig Latin
	 */
	public String translateWord(
		String word)
	{
		return thePrefixPattern.matcher(word.toLowerCase()).replaceFirst("$2$1") + "ay";
	}
}
