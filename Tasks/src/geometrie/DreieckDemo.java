package geometrie;

public class DreieckDemo {
public static void main(String[] args){
	Dreieck d1,d2,d3,d4;
	d1=new Dreieck();
	Punkt[] punkte=new Punkt[3];
	punkte[0]=new Punkt(2,0);
	punkte[1]=new Punkt(3,0);
	punkte[2]=new Punkt(4,1);
	d2=new Dreieck(punkte);
	d3=new Dreieck();
	System.out.println("Eingabe fuer Dreieck:");
	d3.eingabe();
	d4=new Dreieck(d3);
	System.out.println("Ausgabe fuer Objekt 1");
	//d1.ausgabe();
	
	System.out.println("Ausgabe fuer Objekt 2");
	//d2.ausgabe();
	System.out.println("Ausgabe fuer Objekt 3");
	//d3.ausgabe();
	System.out.println("Ausgabe fuer Objekt 4");
	//d4.ausgabe();
   }
}
