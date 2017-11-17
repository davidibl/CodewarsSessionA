package de.lv1871.dms.Codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ChallengeBTest {

	// @formatter:off
	
	// Getestet wird hier die Klasse Breadcrumps. Es geht darum aus einem URL Breadcrumps Code
	// zu erzeugen.
	// BSP:
	// mysite.com/pictures/holidays.html 
	// wird zu
	// <a href=\"/\">HOME</a> : <a href=\"/pictures/\">PICTURES</a> : <span class=\"active\">HOLIDAYS</span>
	// Die Regeln sind einfach:
	// Der vordere Teil der URL wird entfernt und immer als HOME Link dargestellt
	// Die Pfadelement des URL werden als Links dargestellt und sollen Uppercase sein
	// Alle letzten Elemente des Pfads werden als span Elemente mit der Klasse active ausgegeben
	// Immer wenn ein index.* auftaucht wirds ignoriert
	// Alle hintersten Pfadelemente können auf .asp .php .html enden. In diesem Fall wird die Extension
	// in der Darstellung entfernt
	// Bindestriche sollen in der Darstellung zu Leerzeichen werden
	// Pfadelement die länger als 30 Zeichen sind, sollen zu Akronymen werden. Hierzu werden alle
	// Anfangsbuchstaben von Worten die durch einen Trenner erkennbar sind sollen hierbei als Großbuchstaben
	// in der Anziege aneinandergehängt werden. Hierbei sollen folgende Worte ignoriert werden:
	// ["the","of","in","from","by","with","and", "or", "for", "to", "at", "a"]
	// Der Seperator zwischen den Breadcrumps, wird als zweites argument mitgegeben.
	
	// @formatter:on

	@Test
	public void examplesTests() {
		// assertEquals("expected", "actual");

		String[] urls = new String[] { "mysite.com/pictures/holidays.html",
				"www.codewars.com/users/GiacomoSorbi?ref=CodeWars", "www.microsoft.com/docs/index.htm#top",
				"mysite.com/very-long-url-to-make-a-silly-yet-meaningful-example/example.asp",
				"www.very-long-site_name-to-make-a-silly-yet-meaningful-example.com/users/giacomo-sorbi" };

		String[] seps = new String[] { " : ", " / ", " * ", " > ", " + " };

		String[] anss = new String[] {
				"<a href=\"/\">HOME</a> : <a href=\"/pictures/\">PICTURES</a> : <span class=\"active\">HOLIDAYS</span>",
				"<a href=\"/\">HOME</a> / <a href=\"/users/\">USERS</a> / <span class=\"active\">GIACOMOSORBI</span>",
				"<a href=\"/\">HOME</a> * <span class=\"active\">DOCS</span>",
				"<a href=\"/\">HOME</a> > <a href=\"/very-long-url-to-make-a-silly-yet-meaningful-example/\">VLUMSYME</a> > <span class=\"active\">EXAMPLE</span>",
				"<a href=\"/\">HOME</a> + <a href=\"/users/\">USERS</a> + <span class=\"active\">GIACOMO SORBI</span>" };

		for (int i = 0; i < 5; i++) {
			System.out.println(" \nTest with : " + urls[i]);
			String actual = Breadcrumps.generate_bc(urls[i], seps[i]);
			if (!actual.equals(anss[i])) {
				System.out.println(String.format("Expected : %s", reformat(anss[i])));
				System.out.println(String.format("Actual :   %s", reformat(actual)));
			}
			assertEquals(anss[i], actual);
		}
	}

	String reformat(String s) {
		return s.replace("<", "<");
	}

}
