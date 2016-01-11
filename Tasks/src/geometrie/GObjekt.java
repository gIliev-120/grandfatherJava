package geometrie;

import java.awt.Point;

public abstract class GObjekt implements GOZeichnen{
	protected int anzahl;
	protected String name;
	protected Punkt[] eckpunkte;
	protected double[] seiten;
	protected Point[] eckpunkteZ;
	
	
	public GObjekt(String name , int anzahl){
		this.name=name;
		this.anzahl=anzahl;
	}
	
	abstract void eingabe();
	abstract int kontrolle();
	abstract double umfang();
	abstract double flaeche();
	abstract String art();
	abstract void ausgabe();
	abstract boolean equal(GObjekt g);
	
	public void seitenBerechnung(){
		int i,j;
		for(i=0; i<eckpunkte.length; i++) {
			if(i<eckpunkte.length-1)
				j=i+1;
			else
				j=0;
			seiten[i]=Gerade.abstand(eckpunkte[i], eckpunkte[j]);
			
		}	
	}
	
	
	
}
