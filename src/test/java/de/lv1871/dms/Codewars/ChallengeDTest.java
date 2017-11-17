package de.lv1871.dms.Codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ChallengeDTest {

	// @formatter:off
	
	// Es geht um die Klasse StringConversion
	// Die darin enthaltene Funktion soll alle Vokale entfernen. Als Vokale zählen hierbei:
	// "A", "O", "Y", "E", "U", "I"
	// Vor jedem Konsonanten soll dafür ein "." eingefügt werden.
	//
	
	// @formatter:on

	@Test
	public void perform() throws Exception {
		assertEquals(".t.r", StringConversion.perform("tour"));
		assertEquals(".c.d.w.r.s", StringConversion.perform("Codewars"));
		assertEquals(".b.c.b", StringConversion.perform("aBAcAba"));
		assertEquals("", StringConversion.perform("H.uiBydDDd/AberÄuch"));
	}
}
