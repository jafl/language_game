package net.languagegame;

import java.util.Map;
import java.util.Iterator;
import java.util.Locale;

public class InflationaryEnglishTest
    extends junit.framework.TestCase
{
    public void testInflation()
    {
        InflationaryEnglish t = new InflationaryEnglish();

        assertEquals("twoderful", t.translateWord("wonderful"));
        assertEquals("fivehead", t.translateWord("forehead"));
        assertEquals("elevennis", t.translateWord("tennis"));

        assertEquals("twice upon a time", t.translate("once upon a time"));
        assertEquals("Anytwo up five elevennis threegether?", t.translate("Anyone up for tennis together?"));
        assertEquals("ready three GO torque!", t.translate("ready to GO torque!"));
    }
}
