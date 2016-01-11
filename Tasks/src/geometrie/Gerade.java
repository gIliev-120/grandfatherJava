package geometrie;

public class Gerade {
	protected Punkt p1, p2;

	public Gerade() {
		p1 = new Punkt(0, 0);
		p2 = new Punkt(1, 1);
	}

	public Gerade(Punkt t1, Punkt t2) {
		p1 = new Punkt(t1);
		p2 = new Punkt(t2);
	}

	public Gerade(Gerade g) {
		p1 = new Punkt(g.p1);
		p2 = new Punkt(g.p2);
	}

	public int kontrolle() {

		if (p1.equal(p2)) {
			return 1;
		} else {
			return 0;
		}
	}

	public void eingabe() {
		do {
			p1.eingabe();
			p2.eingabe();
			if (kontrolle() > 0) {
				System.out.println("Die Punkte sind gleich! Wiederholen der Eing");
			}
		} while (kontrolle() > 0);
	}

	public String toString() {
		return "Gerade defubuert mit" + p1 + "-" + p2;
	}

	public void ausgabe() {
		System.out.println("Gerade:" + this);
		System.out.println("Abstand zwischen den punkten " + abstand());
		System.out.println("Koeffizient der Gerade:" + koeffizient());

	}

	double abstand() {
		double abst = Math.sqrt(Hilfe.quad(p2.x - p1.x)
				+ Hilfe.quad(p2.y - p1.y));
		return abst;
	}

	double koeffizient() {
		double k;
		double delx = p2.x - p1.x;
		if (Math.abs(delx) > Hilfe.EPSILON) {
			k = (p2.y - p1.y) / delx;
		} else {
			k = 1e8;
		}
		return k;
	}

	public static double abstand(Punkt t1, Punkt t2) {
		double abst = Math.sqrt(Hilfe.quad(t2.x - t1.x)
				+ Hilfe.quad(t2.y - t1.y));
		return abst;
	}

	public static double koeffizient(Punkt t1, Punkt t2) {
		double k;
		double delx = t2.x - t1.x;
		if (Math.abs(delx) > Hilfe.EPSILON) {
			k = (t2.y - t1.y) / delx;
		} else {
			k = 1e8;
		}
		return k;

	}
}
