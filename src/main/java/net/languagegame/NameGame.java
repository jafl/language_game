package net.languagegame;

/**
 * Translates English to the Name Game.
 *
 * @author John Lindal
 * @see http://en.wikipedia.org/wiki/Name_game
 */

public class NameGame
	extends Translator
{
	public NameGame()
	{
	}

	/**
	 * Translates single word from English to the Name Game.
	 * @param text	word
	 * @return		the Name Game
	 */
	public String translateWord(
		String word)
	{
		String lc = word.toLowerCase();

		String x  = lc.substring(0,1).toUpperCase() + lc.substring(1);
		String x1 = lc.replaceFirst("^(qu|[bcdfghjklmnpqrstvwxyz]+)", "");

		if (x1.startsWith("art") ||
			x1.startsWith("uck") ||
			x1.startsWith("ich") ||
			x1.startsWith("itch"))
		{
			return x;
		}

		String x2 = x1, x3 = x1, x4 = x1;
		if (!lc.startsWith("b"))
		{
			x2 = "b" + x2;
		}
		if (!lc.startsWith("f"))
		{
			x3 = "f" + x3;
		}
		if (!lc.startsWith("m"))
		{
			x4 = "m" + x4;
		}

		StringBuilder buf = new StringBuilder();
		buf.append(x)
		   .append(x)
		   .append("Bo")
		   .append(x2)
		   .append("Bananafanafo")
		   .append(x3)
		   .append("Feefimo")
		   .append(x4)
		   .append(x);
		return buf.toString();
	}
}
