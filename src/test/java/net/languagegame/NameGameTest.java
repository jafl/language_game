package net.languagegame;

public class NameGameTest
    extends junit.framework.TestCase
{
    public void testNameGame()
    {
        NameGame t = new NameGame();

        assertEquals("JackJackBobackBananafanafofackFeefimomackJack", t.translateWord("jack"));
        assertEquals("BillyBillyBoillyBananafanafofillyFeefimomillyBilly", t.translateWord("BILLY"));
        assertEquals("FredFredBobedBananafanafoedFeefimomedFred", t.translateWord("FRed"));
        assertEquals("MarshaMarshaBobarshaBananafanafofarshaFeefimoarshaMarsha", t.translateWord("marSHa"));

		assertEquals("Tucker", t.translate("tucker"));
		assertEquals("Chuck", t.translate("chuck"));
		assertEquals("Art", t.translate("art"));
		assertEquals("Mitch", t.translate("mitch"));		
		assertEquals("Richie", t.translate("richie"));		
    }
}
