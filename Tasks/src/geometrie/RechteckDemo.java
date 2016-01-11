package geometrie;

public class RechteckDemo {
	public static void main(String[] args) {
		Rechteck r1, r2, r3, r4;
		r1 = new Rechteck();
		Punkt anfang = new Punkt(1, 1);
		r2 = new Rechteck(anfang, 2, 3);
		r3 = new Rechteck();
		System.out.println("Eingabe fuer Rechteck: ");
		r3.eingabe();
		r4 = new Rechteck(r3);
		System.out.println("Ausgabe fuer Objekt 1");
		r1.ausgabe();
		System.out.println("Ausgabe fuer Objekt 2");
		r2.ausgabe();
		System.out.println("Ausgabe fuer Objekt 3");
		r3.ausgabe();
		System.out.println("Ausgabe fuer Objekt 4");
		r4.ausgabe();
	}
}
