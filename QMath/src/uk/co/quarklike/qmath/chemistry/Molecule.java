package uk.co.quarklike.qmath.chemistry;

import java.util.HashMap;

public class Molecule {
	private HashMap<Element, Integer> molecular;

	public Molecule(String formula) {
		molecular = new HashMap<Element, Integer>();

		int pos = 0;
		char[] f = formula.toCharArray();
		Element e = null;
		String symbol = "";
		String number = "";
		char lastValue = 0;

		while (true) {
			if (pos >= f.length)
				break;
			char c = f[pos];
			if (Character.isDigit(c)) {
				if (Character.isAlphabetic(lastValue)) {
					e = Element.elements.get(symbol);
				}
				number += c;
			} else if (Character.isAlphabetic(c)) {
				if (Character.isDigit(lastValue)) {
					molecular.put(e, Integer.valueOf(number));
					number = "";
					symbol = "";
				} else if (Character.isUpperCase(c) && lastValue != 0) {
					molecular.put(Element.elements.get(symbol), 1);
					symbol = "";
				}
				symbol += c;
			}
			lastValue = c;
			pos++;
		}

		if (number == "")
			number = "1";
		molecular.put(Element.elements.get(symbol), Integer.valueOf(number));
	}

	public boolean isSimple() {
		return this.isEqualTo(((Element) molecular.keySet().toArray()[0]).getStandard());
	}

	public boolean isEqualTo(Molecule m) {
		for (Element e : molecular.keySet()) {
			if (molecular.get(e) != m.molecular.get(e))
				return false;
		}

		return true;
	}
}
