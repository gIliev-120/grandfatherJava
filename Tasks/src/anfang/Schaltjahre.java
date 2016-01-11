package anfang;

import java.util.Scanner;

public class Schaltjahre {
	static Scanner st = new Scanner(System.in);

	public static void main(String[] args) {
		int anzahl,jahr,jahrundert;
		int n=0;
		System.out.println("Anzahl der Schaltjahre");
		anzahl=st.nextInt();
		
		while(n<anzahl){
			System.out.println("Ein Jahr wird angegeben:");
			jahr=st.nextInt();
				if((jahr%4==0&&jahr%100!=0)||jahr%400==0){
					System.out.println("Das Jahr "+jahr+" ist ein Schaltjahr");
					n++;
				}else{
					System.out.println("Das Jahr "+jahr+" ist kein Schaltjahr");
					jahrundert=(jahr-1)/100+1;
					System.out.println("Das Jahr "+jahr+" ist im "+jahrundert+"Jahrundert");
				}
		}
		System.out.println("Ende des Program");

	}
}
