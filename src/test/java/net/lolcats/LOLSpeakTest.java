package net.lolcats;

public class LOLSpeakTest
    extends junit.framework.TestCase
{
    public void testTranzlation()
    {
        LOLSpeak t = new LOLSpeak();

        assertEquals("accustomd", t.translateWord("accustomed"));
        assertEquals("accustomd", t.translate("accustomed"));
        assertEquals("oh hai, me screwd!", t.translate("hi, I'm screwed!"));

        assertEquals("horkshun", t.translate("horktion"));
        assertEquals("horkshuns", t.translate("horktions"));
        assertEquals("horkd", t.translate("horked"));
        assertEquals("horkin", t.translate("Horking"));
        assertEquals("horks", t.translate("horkss"));
        assertEquals("horkr", t.translate("horker"));
        assertEquals("horkus", t.translate("horkous"));
        assertEquals("horkz", t.translate("horks"));
        assertEquals("regreshun", t.translate("regression"));
    }
}
