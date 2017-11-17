package de.lv1871.dms.Codewars;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class ChallengeATest {

	// Es geht um die KLasse Interfacing..
	//
	// Die Aufgabe
	//
	// Eine Methode muss implementiert werden, die ein Objekt zurück gibt die
	// ein paar Interfaces implementiert
	// Die Schwierigkeit:
	// Wir kennen weder Anzahl noch Implementierung der Interfaces. Das einzige
	// was wir wissen
	// ist dass alle Interfaces paare aus gettern und settern implementieren die
	// einen int entgegennehmen
	// bzw. zurück geben.
	// Das heißt jedes Interface hat eine beliebige Anzahl getter und setter
	// Paare
	//
	// Das Objekt das zurückgegeben wird, soll alle Interfaces implementieren.
	//
	// Bei unklarheiten hier einfach fragen.

	private Random random;
	private List<String> names;
	private Class<?>[] interfaces;

	@Test
	public void testCreate() {
		Object o = Interfacing.create(interfaces);

		assertEquals(10, o.getClass().getInterfaces().length);
		assertArrayEquals(interfaces, o.getClass().getInterfaces());

		try {
			for (Class<?> clazz : interfaces) {
				for (Method method : clazz.getMethods()) {
					String name = method.getName();
					if (name.startsWith("set")) {
						String getterName = "get" + name.substring(3);
						Method getter = clazz.getMethod(getterName);

						int number = random.nextInt();
						method.invoke(o, number);

						assertEquals(number, getter.invoke(o));
					}
				}
			}
		} catch (Exception e) {
			fail(e.toString());
		}

		System.out.println("Success!");
	}

	// Nur Setup ab hier.

	@Before
	public void prepare() throws ClassNotFoundException, CannotCompileException {
		random = new Random();
		names = new ArrayList<>();
		interfaces = new Class<?>[10];

		names.addAll(Arrays.asList(new String[] { "Test", "Tests", "Name", "FirstName", "LastName", "Age", "Gender",
				"Date", "Time", "Year", "Month", "Day", "Hour", "Minute", "Second", "Height", "Width", "Make", "Model",
				"Color", "Weight", "Depth", "Texture", "Material", "Status", "State", "Error", "Flag", "None", "Flux",
				"Type", "Vegetable", "Fruit", "Animal", "Human", "Country", "Province", "Territory", "Zone", "Region",
				"Direction", "Vector", "Coordinate", "Friend", "Ally", "Standing", "Reputation", "Create", "Destroy",
				"Build", "Rebuild", "Number", "Condition", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H" }));

		for (int i = 0; i < interfaces.length; i++) {
			interfaces[i] = randomInterface();
		}
	}

	protected Class<?> randomInterface() throws ClassNotFoundException, CannotCompileException {
		String name = randomName();

		int count = random.nextInt(4) + 1;
		ClassPool cp = ClassPool.getDefault();
		CtClass makeInterface = cp.makeInterface(name);

		for (int i = 0; i < count; i++) {
			String propName = randomName();
			CtMethod getter = CtMethod.make("int get" + propName + "();", makeInterface);
			CtMethod setter = CtMethod.make("void set" + propName + "(Object value);", makeInterface);
			makeInterface.addMethod(getter);
			makeInterface.addMethod(setter);
		}
		return makeInterface.toClass();

	}

	protected String randomName() {
		return names.remove(random.nextInt(names.size()));
	}

}
