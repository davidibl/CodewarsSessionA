package de.lv1871.dms.Codewars;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class ChallengeCTest {
	// @formatter:off
	
	// Es geht um die Klasse Robots
	//
	// Hier sollen Roboter gezählt werden die in Strings in einem String Array vorkommen.
	// Jeder String des Arrays enthält ein Schlüsselwort. automatik oder machanik. Je nachdem
	// welches Schlüsselwort in einem String enthalten ist, werden alle Roboter die in dem
	// String gefunden werden zu den mechanischen oder automatischen Robotern gezählt.
	// Unsere Klasse soll ein String array zurück geben, das immer 2 String enthält:
	// 
	// "x robots functioning automatik" Wobei x die Anzahl aller automatischen Roboter ist
	// "x robots dancing mechanik" Wobei x die Anzahl der mechanischen Roboter darstellen soll
	//
	// Woran erkennt man einen Roboter? An den Augen, dem Körper und den Beinen:
	// Bsp: d[(0)(0)]b
	// Leider sehen alle Roboter ein bisschen unterschiedlich aus. Die Produktionsqualität schwankt.
	//
	// Folgende Regeln gelten
	//
	// Die Augen sind immer da und haben einen fixen Platz
	// d[(0)(0)]B 
	// ...0..0...
	//    ^  ^            
	//    |  | 
	//
	// Beine sind immer folgendermaßen dargestellt => abcdefghijklmnopqrstuvwxyz
	// ...0..0... 
	// ^        ^             
	// |        |
	//
	// Der Körper immer folgendermaßen => |};&#[]/><()*
	// ...0..0... 
	// 	^^ ^^ ^^            
	//  || || ||
	
	
	// @formatter:on

	@Test
	public void countRobots_BasicTest1() {
		String[] a = {};
		String[] expectedResult = { "0 robots functioning automatik", "0 robots dancing mechanik" };
		String[] actual = Robots.countRobots(a);
		assertArrayEquals(expectedResult, actual);
	}

	@Test
	public void countRobots_BasicTest2() {
		String[] a = { "We're functioning automatik", "And we are dancing mechanik" };
		String[] expectedResult = { "0 robots functioning automatik", "0 robots dancing mechanik" };
		String[] actual = Robots.countRobots(a);
		assertArrayEquals(expectedResult, actual);
	}

	@Test
	public void countRobots_BasicTest3() {
		String[] a = { "We're functioning automatik d[(0)(0)]b", "And we are dancing mechanik d[(0)(0)]b d[(0)(0)]b" };
		String[] expectedResult = { "1 robots functioning automatik", "2 robots dancing mechanik" };
		String[] actual = Robots.countRobots(a);
		assertArrayEquals(expectedResult, actual);
	}

	@Test
	public void countRobots_BasicTest4() {
		String[] a = { "d[(0)(0)]b We're functioning automatik d[(0)(0)]b",
				"And we are d[(0)(0)]b dancing mechanik d[(0)(0)]b d[(0)(0)]b" };
		String[] expectedResult = { "2 robots functioning automatik", "3 robots dancing mechanik" };
		String[] actual = Robots.countRobots(a);
		assertArrayEquals(expectedResult, actual);
	}

	@Test
	public void countRobots_BasicTest5() {
		String[] a = { "d[(0)(0)}b We're functioning automatik D[(0)(0)]b",
				"And we are d[(0)(0}]b dancing mechanik d[(0)(0)]b c[(0)(0)]b" };
		String[] expectedResult = { "2 robots functioning automatik", "3 robots dancing mechanik" };
		String[] actual = Robots.countRobots(a);
		assertArrayEquals(expectedResult, actual);
	}

	@Test
	public void countRobots_BasicTest6() {
		String[] a = { "d*(0)(0)}b We're functioning e(<0/>0]#m Automatik Roboter0%1 D[(0)(0)]b",
				"And we are d[(0)(0}]b dancing mechanik d[(0)(0)]b c[(0)(0)]b" };
		String[] expectedResult = { "3 robots functioning automatik", "3 robots dancing mechanik" };
		String[] actual = Robots.countRobots(a);
		assertArrayEquals(expectedResult, actual);
	}

	@Test
	public void countRobots_BasicTest7() {
		String[] a = { "d*(0)(0)}b We're functioning d>[0;;0&&f automatik D[(0)(0)]b",
				"and m><0(;0[;a we dancing are Mechanic" };
		String[] expectedResult = { "3 robots functioning automatik", "0 robots dancing mechanik" };
		String[] actual = Robots.countRobots(a);
		assertArrayEquals(expectedResult, actual);
	}

	@Test
	public void countRobots_BasicTest8() {
		String[] a = { "We're charging our battery", "And now we're full of energy", "We are the robots",
				"We're functioning automatik", "And we are dancing mechanik", "We are the robotororo robots",
				"Ja tvoi sluga", "Ja tvoi Rabotnik robotnik", "We are programmed just to do", "anything you want us to",
				"we are the robots", "We're functioning Automatic", "and we are dancing Mechanic", "we are the robots",
				"Ja tvoi sluga", "Ja tvoi Rabotnik robotnik", "We are the robots",
				"d*(0)(0)}b We're functioning automatik D[(0)(0)]b",
				"And we are d[(0)(0}]b dancing mechanik Roboter0%1 d[(0)(0)]b c[(0)(0)]b" };

		String[] expectedResult = { "2 robots functioning automatik", "3 robots dancing mechanik" };
		String[] actual = Robots.countRobots(a);
		assertArrayEquals(expectedResult, actual);
	}

	@Test
	public void countRobots_BasicTest9() {
		String[] a = { "d (0)(0)}b We're functioning &>[0;;0&&f automatik D[(0 (0)]b",
				"and m><0(;0 ;a we dancing are Mechanic" };
		String[] expectedResult = { "0 robots functioning automatik", "0 robots dancing mechanik" };
		String[] actual = Robots.countRobots(a);
		assertArrayEquals(expectedResult, actual);
	}
}