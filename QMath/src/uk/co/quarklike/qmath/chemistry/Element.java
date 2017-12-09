package uk.co.quarklike.qmath.chemistry;

import java.util.HashMap;

public class Element {
	public static HashMap<String, Element> elements = new HashMap<String, Element>();

	private String symbol;
	private Molecule standard;

	public static final Element hydrogen = new Element("H").setStandard(new Molecule("H2"));
	public static final Element helium = new Element("He");
	public static final Element lithium = new Element("Li");
	public static final Element carbon = new Element("C");
	public static final Element nitrogen = new Element("N");
	public static final Element oxygen = new Element("O").setStandard(new Molecule("O2"));
	public static final Element fluorine = new Element("F").setStandard(new Molecule("F2"));
	public static final Element neon = new Element("Ne");
	public static final Element sodium = new Element("Na");
	public static final Element magnesium = new Element("Mg");
	public static final Element potassium = new Element("K");
	public static final Element manganese = new Element("Mn");

	public Element(String symbol) {
		this.symbol = symbol;
		elements.put(symbol, this);
		setStandard(new Molecule(symbol));
	}

	public Element setStandard(Molecule standard) {
		this.standard = standard;
		return this;
	}

	public Molecule getStandard() {
		return this.standard;
	}
}
