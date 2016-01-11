package anfang;

import java.util.Scanner;

public class fvonx {
		public static void main(String[] args){
		Scanner sc = new Scanner (System.in);
		double a, xAnf, xEnd, xSch;
		System.out.println("Geben Sie ein Anfangswert fuer x");
		xAnf = sc.nextDouble();
		System.out.println("Geben Sie ein Endwert fuer x");
		xEnd = sc.nextDouble();
		System.out.println("Geben Sie einem konstanten Schritt");
		xSch = sc.nextDouble();
		System.out.println("Geben Sie die Werte fuer a");
		a = sc.nextDouble();
		sc.close ();
		System.out.println("x" + "      " + "f(x)");
		double x, y;
		for (x=xAnf; x<=xEnd; x+=xSch){
			y = a*x*x+(2*x-4)/(2*x+4)+x*x*x;
			if (Math.abs(x-2)>1.0e-4){
			System.out.println( x + "   " + y );}
			else {
				System.out.println( x + "undefinitert");}
			}}}
