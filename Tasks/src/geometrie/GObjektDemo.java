package geometrie;
public class GObjektDemo {
	static GObjekt[] objekte=new GObjekt[9];
	public static void init(){
		Punkt anf=new Punkt(1,0);
		objekte[0]=new Rechteck(anf,2,1.5);
		
		anf=new Punkt(4,0);
		objekte[1]=new Rechteck(anf,2.5,1.5);
		
		anf=new Punkt(3,3);
		objekte[2]=new Rechteck(anf,1,2);
		
		Punkt[]   p=new Punkt[3];
		p[0]=new Punkt(1,1.5);
		p[1]=new Punkt(1,3);
		p[2]=new Punkt(0,3);
		objekte[3]=new Dreieck(p);
		
		Punkt[]   q=new Punkt[3];
		q[0]=new Punkt(3,1.5);
		q[1]=new Punkt(3,3);
		q[2]=new Punkt(2,3);
		objekte[4]=new Dreieck(q);
		
		Punkt[]   z=new Punkt[4];
		z[0]=new Punkt(4,1.5);
		z[1]=new Punkt(6.5,1.5);
		z[2]=new Punkt(5,3);
		z[3]=new Punkt(5.5,3);
		objekte[5]=new Viereck(z);
	
		anf=new Punkt(0.5,3);
		objekte[6]=new Ellipse (anf,1,1);
		
		anf=new Punkt(4,3);
		objekte[7]=new Ellipse (anf,1,1);

		anf=new Punkt(1.5,5);
		objekte[8]=new Ellipse (anf,2,1);
		
	
	}
public static void main(String[]args) {
	init();
	double gesamtFlaeche=0; 
	for(int i=0;i<objekte.length;i++)
	{ 
		gesamtFlaeche+=objekte[i].flaeche();
	}
	for(int i=0; i<objekte.length; i++)
		objekte[i].ausgabe();
	System.out.println("Die Gesamtflaeche ist: " + gesamtFlaeche); }
}
