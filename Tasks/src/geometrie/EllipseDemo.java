package geometrie;

public class EllipseDemo {
	public static void main(String[] args) {
		Ellipse e1,e2,e3,e4;
		e1 =new Ellipse();
		Punkt anfang= new Punkt(1,1);
		e2=new Ellipse(anfang,2.2,3.3);
		e3=new Ellipse();
		
		System.out.println("Eingabe fuer Ellipse:");
		e3.eingabe();
		e4=new Ellipse(e3);
		System.out.println("Ausgabe fuer Object1");
		e1.ausgabe();
		System.out.println("Ausgabe fuer Object2");
		e2.ausgabe();
		System.out.println("Ausgabe fuer Object3");
		e3.ausgabe();
		System.out.println("Ausgabe fuer Object4");
		e4.ausgabe();
		
	}
}
