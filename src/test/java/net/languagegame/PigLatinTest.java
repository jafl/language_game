package net.languagegame;

public class PigLatinTest
    extends junit.framework.TestCase
{
    public void testPigLatin()
    {
        PigLatin t = new PigLatin();

        assertEquals("eastbay", t.translateWord("beast"));
        assertEquals("oughday", t.translate("dough"));
        assertEquals("appyhay", t.translate("Happy"));
        assertEquals("estionquay", t.translate("question"));
        assertEquals("arstay", t.translate("star"));
        assertEquals("eethray", t.translate("three"));
        assertEquals("eagleay", t.translate("eagle"));
        assertEquals("ayspray", t.translate("spray"));
        assertEquals("ayspray", t.translate("prays"));
    }
}
