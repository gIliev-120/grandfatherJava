package geometrie;

import java.awt.Graphics;
import java.awt.Point;

public class Viereck extends GObjekt {
	public Viereck() {
		super ("Viereck",4);
		eckpunkte = new Punkt[anzahl];
		seiten = new double[anzahl];
		eckpunkte[0] = new Punkt(0, 0);
		eckpunkte[1] = new Punkt(1, 0);
		eckpunkte[2] = new Punkt(1, 1);
		eckpunkte[3] = new Punkt(0, 1);
		seitenBerechnung();		
	}

	public Viereck(Punkt[] eck)
	{	
		super("Viereck",4);
		eckpunkte=new Punkt[anzahl];
		seiten=new double[anzahl];
		for(int i=0;i<eck.length;i++)
			eckpunkte[i]=new Punkt(eck[i]);
		seitenBerechnung();
	}

	public Viereck(Viereck v) {
		super ("Viereck",4);
		eckpunkte = new Punkt[anzahl];
		seiten = new double[anzahl];
		for (int i = 0; i < v.eckpunkte.length; i++)
			eckpunkte[i] = new Punkt(v.eckpunkte[i]);
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
		Punkt p1 = eckpunkte[0], p2 = eckpunkte[1], p3 = eckpunkte[2], p4 = eckpunkte[3];
		if (Hilfe.equal(p1.x, p2.x) && Hilfe.equal(p1.y, p2.y))
			return 1;
		else if (Math.abs(Dreieck.flaeche(p1, p2, p3)) < Hilfe.EPSILON)
			return 2;
		else {
			double fla1, fla2, fla3;
			fla1 = Dreieck.flaeche(p1, p2, p4);
			fla2 = Dreieck.flaeche(p1, p3, p4);
			fla3 = Dreieck.flaeche(p2, p3, p4);
			if ((Hilfe.signum(fla1) != Hilfe.signum(fla2))
					|| (Hilfe.signum(fla1) != Hilfe.signum(fla3) || (Hilfe
							.signum(fla2) != Hilfe.signum(fla3))))
				return 3;
			else
				return 0;

		}
	}

	public void eingabe() {
		do {
			System.out.println("Eingabe fuer Viereck:");
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
		double a = seiten[0], b = seiten[1], c = seiten[2], d = seiten[3];
		double p = (a + b + c + d);
		return p;
	}
	public double flaeche(){
		double s1,s2;
		double a=seiten[0], b=seiten[1], c=seiten[2], d=seiten[3];
		double p1=(a+b+c)/2;
		double p2=(a+c+d)/2;
		s1=Math.sqrt(p1*(p1-a)*(p1-b)*(p1-c));
		s2=Math.sqrt(p2*(p2-a)*(p2-b)*(p2-d));
		return s1+s2;
	}
	public static double flaeche(Punkt t1, Punkt t2, Punkt t3) {
		double m=t1.x*(t2.y-t3.y)+t2.x*(t3.y-t1.y)+t3.x*(t1.y-t2.y);
	return 0.5*m;
}
	public String art(){
		String s="Ein gewohnlicher Viereck";
		double a,b,c,d;
		a=Gerade.koeffizient(eckpunkte[0], eckpunkte[1]);
		b=Gerade.koeffizient(eckpunkte[1], eckpunkte[2]);
			c=Gerade.koeffizient(eckpunkte[2], eckpunkte[3]);
			d=Gerade.koeffizient(eckpunkte[3], eckpunkte[0]);
			if (Hilfe.equal(a, c) || Hilfe.equal(b, d)) s="Trapez";
			else if (Hilfe.equal(a, c) && Hilfe.equal(b, d)) s="Paralelepiped";
			return s;
		
	}
	
	public boolean equal(Viereck v){
		double a=seiten[0], b=seiten[1], c=seiten[2], d=seiten[3];
		double a1=v.seiten[0], b1=v.seiten[1], c1=v.seiten[2], d1=v.seiten[3];
		
		if(Hilfe.equal(a,a1) && Hilfe.equal(b,b1) && Hilfe.equal(c,c1)&& Hilfe.equal(d,d1)){
			return true;
		}else{
			return false;
		}
	
	}
	public void ausgabe(){
		System.out.println("Eckpunkte1"+eckpunkte[0]+"Eckpunkte2"+eckpunkte[1]+"Eckpunkte"+eckpunkte[2]);
		System.out.println("Umfang"+umfang());
		System.out.println("Flaeche"+flaeche());
		System.out.println("art"+art());
	}

	boolean equal(GObjekt g) {
		// TODO Auto-generated method stub
		return false;
	}

	public void zeichnen(Graphics g, double koef){
		eckpunkteZ = new Point[anzahl];
		for (int i = 0; i < eckpunkteZ.length; i++) {
			eckpunkteZ[i] = new Point((int) (eckpunkte[i].x * koef),
					(int) (eckpunkte[i].y * koef));
		}
			int mx[],my[];
			mx= new int[eckpunkteZ.length];
			my= new int[eckpunkteZ.length];
			for(int i=0;i<eckpunkteZ.length;i++){
				mx[i]=eckpunkteZ[i].x;
				my[i]=eckpunkteZ[i].y;
			}
			g.drawPolygon(mx, my, eckpunkteZ.length);
		}
		
	
	public boolean contains(int x,int y)
	{
		double gesflaeche;
		Punkt m=new Punkt(x,y);
        Punkt p1=new Punkt(eckpunkteZ[0].x,eckpunkteZ[0].y);
        Punkt p2=new Punkt(eckpunkteZ[1].x,eckpunkteZ[1].y);
        Punkt p3=new Punkt(eckpunkteZ[2].x,eckpunkteZ[2].y);
        Punkt p4=new Punkt(eckpunkteZ[3].x,eckpunkteZ[3].y);
        Punkt[] punkte1 = {
            	p1, p2, m
            };
            Punkt[] punkte2 = {
        		p2, p3, m	
            };
            Punkt[] punkte3 = {
            		p3, p4,	m
                };
            Punkt[] punkte4 = {
            		p4, p1,	m
                };
		Dreieck dr1 = new Dreieck(punkte1),	dr2 = new Dreieck(punkte2),	dr3 = new Dreieck(punkte3),	dr4 = new Dreieck(punkte4);
		gesflaeche= dr1.flaeche()+dr2.flaeche()+dr3.flaeche()+dr4.flaeche();
		if (Math.abs(gesflaeche-Math.abs(Dreieck.flaeche(p1,p2,p3)+Dreieck.flaeche(p1,p3,p4)))<Hilfe.EPSILON)
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
