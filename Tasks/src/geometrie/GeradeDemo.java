package geometrie;

public class GeradeDemo {
	public static void main(String[] args) {
		Gerade g1,g2,g3,g4;
		Punkt t1,t2;
		
		t1=new Punkt(0,0);
		t2=new Punkt(2.3,3.4);
		
		g1=new Gerade();
		g2=new Gerade(t1,t2);
		g3=new Gerade();
		System.out.println();
		System.out.println("Eingabe fuer Objekt3");
		g3.eingabe();
		g4=new Gerade(g3);
		System.out.println();
		System.out.println("Ausgabe fuer Objekt1");
		g1.ausgabe();
		System.out.println("Ausgabe fuer Objekt2");
		g2.ausgabe();
		System.out.println("Ausgabe fuer Objekt3");
		g3.ausgabe();
		System.out.println("Ausgabe fuer Objekt4");
		g4.ausgabe();
		
		Punkt z1= new Punkt(2,3);
		Punkt z2= new Punkt(5,6);
		
		double ab=Gerade.abstand(z1,z2);
		double ko=Gerade.koeffizient(z1, z2);
		
		System.out.println("Der Abstand zwischen Den Punkten: "+z1+" und "+z2+" ist "+ab);
		System.out.println("Der Koeffizient der Gerade definiert bei den Punkten: "+z1+" und "+z2+" ist "+ko);
		
	}
}
