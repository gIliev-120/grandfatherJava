package geometrie;

import java.awt.Graphics;
import java.awt.Point;

public class Dreieck extends GObjekt {
	public Dreieck() {
		super("Dreieck", 3);
		eckpunkte = new Punkt[anzahl];
		eckpunkte[0] = new Punkt(0, 0);
		eckpunkte[0] = new Punkt(1, 0);
		eckpunkte[0] = new Punkt(0, 1);
		seiten = new double[anzahl];
		seitenBerechnung();
	}

	public Dreieck(Punkt[] eck) {
		super("Dreieck", 3);
		eckpunkte = new Punkt[anzahl];
		seiten = new double[anzahl];
		for (int i = 0; i < eck.length; i++)
			eckpunkte[i] = new Punkt(eck[i]);
		seitenBerechnung();
	}

	public Dreieck(Dreieck dr) {
		super("Dreieck", 3);
		eckpunkte = new Punkt[anzahl];
		seiten = new double[anzahl];
		for (int i = 0; i < anzahl; i++)
			eckpunkte[i] = new Punkt(dr.eckpunkte[i]);
		seitenBerechnung();
	}

	public void seitenBerechnung() {
		int i, j;
		for (i = 0; i < eckpunkte.length; i++) {
			if (i < eckpunkte.length - 1)
				j = i + 1;
			else
				j = 0;
			seiten[i] = Gerade.abstand(eckpunkte[i], eckpunkte[j]);
		}
	}

	public int kontrolle() {
		Punkt p1 = eckpunkte[0], p2 = eckpunkte[1], p3 = eckpunkte[2];
		if (p1.equal(p2))
			return 1;
		else if (Math.abs(flaeche(p1, p2, p3)) < Hilfe.EPSILON)
			return 2;
		else
			return 0;
	}

	public void eingabe() {
		do {
			System.out.println("Eingabe fur Dreieck:");
			for (int i = 0; i < eckpunkte.length; i++) {
				System.out.println("Koordinaten fuer Punkt" + (i + 1));
				eckpunkte[i].eingabe();
			}
			if (kontrolle() > 0)
				System.out.println("Falscher Punkt:" + kontrolle());
		} while (kontrolle() > 0);
		seitenBerechnung();
	}

	public double umfang() {
		return anzahl;
	}

	public double flaeche() {
		double a = seiten[0], b = seiten[1], c = seiten[2];
		double p = (a + b + c) / 2;
		return Math.sqrt(p * (p - a) * (p - b) * (p - c));
	}

	public static double flaeche(Punkt t1, Punkt t2, Punkt t3) {
		double m = t1.x * (t2.y - t3.y) + t2.x * (t3.y - t1.y) + t3.x
				* (t1.y - t2.y);
		return 0.5 * m;
	}

	public String art() {
		String s;
		double a = seiten[0], b = seiten[1], c = seiten[2];
		if (Hilfe.equal(a, b) && Hilfe.equal(b, c))
			s = "gleichseitig";
		else if (Hilfe.equal(a, b) || Hilfe.equal(b, c) || Hilfe.equal(a, c))
			s = "Gleichschenklig";
		else
			s = "Allgemein";
		if (Hilfe.equal(maxWinkel(), Math.PI / 2))
			s = s + " rechtwinklig";
		else if (maxWinkel() < Math.PI / 2)
			s = s + " spitzwinklig";
		else
			s = s + " stumpfwinklig";
		return s;
	}

	public boolean equal(Dreieck d) {
		double a1 = seiten[0], b1 = seiten[1], c1 = seiten[2];
		double a2 = d.seiten[0], b2 = d.seiten[1], c2 = d.seiten[2];
		if (Hilfe.equal(a1, a2) && Hilfe.equal(b1, b2) && Hilfe.equal(c1, c2))
			return true;
		else
			return false;
	}

	static double winkel(double a, double b, double c) {
		double wink = ((b * b + c * c - a * a) / (2 * b * c));
		double alfa = Math.acos(wink);
		return alfa;
	}

	double maxWinkel() {
		double alfa = winkel(seiten[0], seiten[1], seiten[2]);
		double beta = winkel(seiten[1], seiten[2], seiten[0]);
		double gamma = winkel(seiten[2], seiten[0], seiten[1]);
		if (alfa < beta)
			if (beta < gamma)
				return gamma;
			else
				return beta;
		return alfa;
	}

	public String toString() {
		return "Dreieck mit: " + eckpunkte[0] + "-" + eckpunkte[1] + "-"
				+ eckpunkte[2];
	}

	void ausgabe() {
		// TODO Auto-generated method stub

	}

	boolean equal(GObjekt g) {
		// TODO Auto-generated method stub
		return false;
	}

	public void zeichnen(Graphics g, double koef) {
		eckpunkteZ = new Point[anzahl];
		for (int i = 0; i < eckpunkteZ.length; i++) {
			eckpunkteZ[i] = new Point((int) (eckpunkte[i].x * koef),
					(int) (eckpunkte[i].y * koef));
		}
		int mx[], my[];
		mx = new int[eckpunkteZ.length];
		my = new int[eckpunkteZ.length];
		for (int i = 0; i < eckpunkteZ.length; i++) {
			mx[i] = eckpunkteZ[i].x;
			my[i] = eckpunkteZ[i].y;
		}
		g.drawPolygon(mx, my, eckpunkteZ.length);
	}

	public boolean contains(int x,int y){
		double gesflaeche;
		Punkt m=new Punkt(x,y);
        Punkt p1=new Punkt(eckpunkteZ[0].x,eckpunkteZ[0].y);
        Punkt p2=new Punkt(eckpunkteZ[1].x,eckpunkteZ[1].y);
        Punkt p3=new Punkt(eckpunkteZ[2].x,eckpunkteZ[2].y);
        Punkt[] punkte1 = {
        	p1, p2, m
        };
        Punkt[] punkte2 = {
    		p2, m, p3	
        };
        Punkt[] punkte3 = {
        		p3, p1,	m
            };
		Dreieck dr1 = new Dreieck(punkte1),	dr2 = new Dreieck(punkte2),	dr3 = new Dreieck(punkte3);
		gesflaeche= dr1.flaeche()+dr2.flaeche()+dr3.flaeche();
		if (Math.abs(gesflaeche-Math.abs(flaeche(p1,p2,p3)))<Hilfe.EPSILON)
			return true;
		else return false;
	}

	public static boolean vertikale(Point m, Point p1, Point p2) {
		if (p1.x == m.x
				&& ((p1.y <= m.y && p2.y >= m.y) || (p1.y >= m.y && p2.y <= m.y))) {
				return true;
		}else{
			return false;
		}

	}
	
	public static Point schnittPunkt(Point m, Point p1, Point p2){
		int y0=p1.y+(int)((m.x-p1.x)*(p2.y-p1.y)/(p2.x-p1.x));
		if(m.x>p1.x && m.x<p2.x){
			return new Point(m.x,y0);
		}
		return null;
	}

}
