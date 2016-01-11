package anfang;

import java.util.Scanner;

public class UmwandlungVonWinkelabmessungen {
		public static final double PI=3.14159;
		static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		double winkelwert;
		char einheit;
		do{
			winkelwert=sc.nextDouble();
			String s = sc.next();
			einheit=s.charAt(0);
			if(einheit=='r'){
				winkelwert=winkelwert/(PI*180);
				System.out.println("Der Winkel ist: "+winkelwert);
			}else if(einheit=='g'){
				
			}
		}while(einheit=='r'||einheit=='g');
		System.out.println("Byee");
	}
}
