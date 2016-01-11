package anfang;

import java.util.Scanner;

public class DreieckBerechnung2 {
	static Scanner st = new Scanner(System.in);

	public static void main(String[] args) {
		double a, b, c;
		a = st.nextDouble();
		b = st.nextDouble();
		c = st.nextDouble();
		
		if((a>0)&&(b>0)&&(c>0)&&(a+b>c)&&(b+c>a)&&(c+a>b)){
			double p=(a+b+c)/2;
			double S=Math.sqrt(p*(p-a)*(p-b)*(p-c));
			System.out.println("Liceto e "+S);
			System.out.println("Das Dreieck ist:");
			
			if((a==b)&&(b==c)){
				System.out.println("gleichseitig");
			}else if((a==b)||(b==c)||(c==a)){
				System.out.println("gleichboeckig");
			}else{
				System.out.println("ungleichseitig");
			}
		}else{
			System.out.println("Die Werte sind nicht korekt fuer Seiten eines Dreiecks");
		}
	}
}
