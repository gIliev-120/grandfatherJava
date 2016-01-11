package geometrie;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.TextField;

public class GOZeichnenApp extends Applet {
	static GObjekt[] objekte = new GObjekt[10];
	static TextField textfield;

	public void init() {
		Punkt anf = new Punkt(1, 0);
		objekte[0] = new Rechteck(anf, 2, 1.5);

		Punkt[] pp = new Punkt[3];
		pp[0] = new Punkt(7, 2);
		pp[1] = new Punkt(7, 4);
		pp[2] = new Punkt(8, 3);
		objekte[1] = new Dreieck(pp);

		anf = new Punkt(3, 3);
		objekte[2] = new Rechteck(anf, 1, 2);

		Punkt[] p = new Punkt[3];
		p[0] = new Punkt(1, 1.5);
		p[1] = new Punkt(1, 3);
		p[2] = new Punkt(0, 3);
		objekte[3] = new Dreieck(p);

		Punkt[] q = new Punkt[3];
		q[0] = new Punkt(3, 1.5);
		q[1] = new Punkt(3, 3);
		q[2] = new Punkt(2, 3);
		objekte[4] = new Dreieck(q);

		Punkt[] z = new Punkt[4];
		z[0] = new Punkt(4, 1.5);
		z[1] = new Punkt(6.5, 1.5);
		z[2] = new Punkt(5.8, 3);
		z[3] = new Punkt(4.8, 3);
		objekte[5] = new Viereck(z);

		anf = new Punkt(0.5, 3);
		objekte[6] = new Ellipse(anf, 1, 1);

		anf = new Punkt(4, 3);
		objekte[7] = new Ellipse(anf, 1, 1);

		anf = new Punkt(3, 5);
		objekte[8] = new Ellipse(anf, 2, 1);

		Punkt[] zz = new Punkt[4];
		zz[0] = new Punkt(0, 5);
		zz[1] = new Punkt(2.5, 5);
		zz[2] = new Punkt(2.5, 7);
		zz[3] = new Punkt(0, 7);

		objekte[9] = new Viereck(zz);

		this.addMouseListener(new Fenster());
		textfield = new TextField("Objekt", 20);
		this.add(textfield);

	}

	public void paint(Graphics g) {
		int i;
		double koef = 30;
		double gesamtFlaeche = 0;
		for (i = 0; i < objekte.length; i++) {
			gesamtFlaeche += objekte[i].flaeche();
		}
		for (i = 0; i < objekte.length; i++) {
			objekte[i].zeichnen(g, koef);

		}

		g.drawString("Anzahl=" + objekte.length, 220, 20);

		g.drawString("Gesamteflaeche=" + gesamtFlaeche, 220, 30);

	}

}

class Fenster implements MouseListener {

	public void mouseClicked(MouseEvent event) {
		boolean click=false;
		int i=0;
		do{
			if(GOZeichnenApp.objekte[i]!=null&&GOZeichnenApp.objekte[i].contains(event.getX(),event.getY())){
				click=true;
				GOZeichnenApp.textfield.setText(GOZeichnenApp.objekte[i].name);
			}else{ 
				i++;
			}
		}while(!click&&i<GOZeichnenApp.objekte.length);
		if(!click){
			GOZeichnenApp.textfield.setText("KeinObjekt");
		}
	}
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}