package geometrie;

import java.awt.Graphics;
import java.awt.Point;

public class Rechteck extends GObjekt{
	protected double br, ho;
	protected int brZ, hoZ;

	public Rechteck() {
		super("Rechteck",1);
		eckpunkte = new Punkt[anzahl];
		eckpunkte[0] = new Punkt(0, 0);
		br = 1;
		ho = 1;
	}

	public Rechteck(Punkt anfangsPunkt, double breite, double hoehe) {
		super("Rechteck",1);
		eckpunkte = new Punkt[anzahl];
		eckpunkte[0] = new Punkt(anfangsPunkt);
		br = breite;
		ho = hoehe;
	}

	public Rechteck(Rechteck r) {
		super("Rechteck",1);
		eckpunkte = new Punkt[anzahl];
		eckpunkte[0] = new Punkt(r.eckpunkte[0]);
		br = r.br;
		ho = r.ho;
	}

	public int kontrolle() {
		if (br <= 0) {
			return 1;
		} else if (ho <= 0) {
			return 2;
		} else {
			return 0;
		}
	}

	public void eingabe() {
		System.out.println("Eingabe fuer Rechteck:");
		System.out.println("Koordinaten fuer Anfangspunkt ");
		eckpunkte[0].eingabe();
		do {
			System.out.println("breite=");
			br = Hilfe.sc.nextDouble();
			System.out.println("hoehe=");
			ho = Hilfe.sc.nextDouble();
			if (kontrolle() > 0)
				System.out.println("Falsche Werte " + kontrolle());
		} while (kontrolle() > 0);
	}

	public double umfang(){
		return 2*(br+ho);
	}
	public double flaeche(){
		return br*ho;
	}

	public String art() {
		String s;
		if (br == ho)
			s = "Quadrat";
		else
			s = "Rechteck";
		return s;
	}

	public String toString() {
		return "Rechteck mit: " + eckpunkte[0] + "breite=" + br + "hoehe=" + ho;
	}

	public void ausgabe() {
		System.out.println(this);
		System.out.println("Umfang=" + umfang());
		System.out.println("Flaeche=" + flaeche());
		System.out.println("Art ist " + art());
	}

	public boolean equal(Rechteck r) {
		if ((Hilfe.equal(this.br, r.br) && Hilfe.equal(this.ho, r.ho))
				|| (Hilfe.equal(this.br, r.ho) && Hilfe.equal(this.ho, r.br))) {
			return true;
		} else {
			return false;
		}
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
		brZ=(int)(br*koef);
		hoZ=(int)(ho*koef);
		g.drawRect(eckpunkteZ[0].x,eckpunkteZ[0].y,brZ,hoZ);
		
	}

	public boolean contains(int x, int y) {
	
			if(x>eckpunkteZ[0].x && x<(eckpunkteZ[0].x+brZ))
				{
				if(y>eckpunkteZ[0].y && y<(eckpunkteZ[0].y+hoZ))
					return true;
				}
				else 
					return false;
			return false;
		}


}
