package anfang;

import java.util.Scanner;

public class DreiechBerechnung1 {
	static Scanner st = new Scanner(System.in);

	public static void main(String[] args) {
		double a, b, c;
		do{
			a = st.nextDouble();
			b = st.nextDouble();
			c = st.nextDouble();
			
			double p=(a+b+c)/2;
			
			double S=Math.sqrt(p*(p-a)*(p-b)*(p-c));
			System.out.println(S);	
		}while(a>0&&b>0&&c>0);
		System.out.println("Good BYE");
		
	}
}
