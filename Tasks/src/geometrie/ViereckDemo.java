package geometrie;

public class ViereckDemo {
	public static void main(String[] args) {
		Viereck v1,v2,v3,v4;
		Punkt[] punkte = new Punkt[4];
		v1=new Viereck();
		punkte[0]=new Punkt(0,0);
		punkte[1]=new Punkt(3,0);
		punkte[2]=new Punkt(2,1);
		punkte[3]=new Punkt(1,1);
		
		v2=new Viereck(punkte);
		v3 = new Viereck();
		System.out.println("Eingabe fuer Viereck:");
		v3.eingabe();
		v4=new Viereck(v3);
		
		v1.ausgabe();
		System.out.println("Ausgabe fuer Objekt 2");
		v2.ausgabe();
		System.out.println("Ausgabe fuer Objekt 3");
		v3.ausgabe();
		System.out.println("Ausgabe fuer Objekt 4");
		v4.ausgabe();
		
		if(v2.equal(v4)){
			System.out.println("Die vierecke sind gleich");
		}else{
			System.out.println("Die Vierecke sind nicht gleich");
		}
		
	}
	

}
