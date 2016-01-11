package geometrie;

import java.awt.Graphics;
import java.awt.Point;

public class Ellipse extends GObjekt{
		protected double a, b;
		protected int aZ,bZ;

	public Ellipse() {
		super("Ellipse",1);
		eckpunkte = new Punkt[anzahl];
		eckpunkte[0] = new Punkt(0, 0);
		a = 1;
		b = 1;
	}

	public Ellipse(Punkt anfangsPunkt, double aN, double bN) {
		super("Ellipse",1);
		eckpunkte = new Punkt[anzahl];
		eckpunkte[0] = new Punkt(anfangsPunkt);
		a = aN;
		b = bN;
	}

	public Ellipse(Ellipse e) {
		super("Ellipse",1);
		eckpunkte = new Punkt[anzahl];
		eckpunkte[0] = new Punkt(e.eckpunkte[0]);
		a = e.a;
		b = e.b;
	}

	public int kontrolle() {
		if (a <= 0) {
			return 1;
		} else if (b <= 0) {
			return 2;
		} else {
			return 0;
		}
	}

	public void eingabe() {
		System.out.println("Eingabe fuer Ellipse:");
		System.out.println("Koordinaten fuer Anfangspunkt ");
		eckpunkte[0].eingabe();
		do {
			System.out.println("Halbachse a=");
			a = Hilfe.sc.nextDouble();
			System.out.println("Halbachse b=");
			b = Hilfe.sc.nextDouble();
		} while (kontrolle() > 0);
	}

	public double umfang() {
		double abs = Math.abs(3 * (a + b)
				- Math.sqrt((3 * a + b) * (a + 3 * b)));
		double umfang = Math.PI * abs;
		return umfang;
	}

	public double flaeche() {
		double fl = Math.PI * a * b;
		return fl;
	}

	public String art() {
		String s = "";
		if (Hilfe.equal(a, b))
			s = "Kreis";
		else
			s = "Ellipse";
		return s;
	}

	public String toString() {
		return "Anfang: " + eckpunkte[0] + ", Halbachse a= " + a
				+ ", Halbachse b= " + b;
	}

	public void ausgabe() {
		toString();
		System.out.println("Die Ellipse ist " + art() + " mit Umfang "
				+ umfang() + " und Flaeche" + flaeche());
	}

	public boolean equal(Ellipse ell) {
		if ((Hilfe.equal(this.a, ell.a) && Hilfe.equal(this.b, ell.b))
				|| (Hilfe.equal(this.a, ell.b) && Hilfe.equal(this.b, ell.a))) {
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
		eckpunkteZ=new Point[anzahl];
		
		for (int i = 0; i < eckpunkteZ.length; i++) {
			eckpunkteZ[i] = new Point((int) (eckpunkte[i].x * koef),
					(int) (eckpunkte[i].y * koef));
		}
		
		aZ=(int)(a*koef);
		bZ=(int)(b*koef);
		g.drawArc(eckpunkteZ[0].x,eckpunkteZ[0].y,2*aZ,2*bZ,0,360);
	}

	public boolean contains(int x,int y)
	{	
		double p,yu,yo;
		int b2=bZ*bZ;
		int a2=aZ*aZ;
		int xC=x-(eckpunkteZ[0].x+aZ);
		p=(Math.sqrt((b2*(a2-(xC*xC)))))/aZ;
		yu=eckpunkteZ[0].y+bZ-p;
		yo=eckpunkteZ[0].y+bZ+p;
		if (y>=yu&&y<yo)
			return true;	
		return false;
	}

}
