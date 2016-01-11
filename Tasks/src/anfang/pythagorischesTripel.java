package anfang;

import java.util.Scanner;

public class pythagorischesTripel {
	static Scanner st = new Scanner(System.in);

	public static void main(String[] args) {
		int maxi;
		maxi = st.nextInt();
		for (int a = 1; a <= maxi; a++) {
			for (int b = 1; b <= maxi; b++) {
				for (int c = 1; c <= maxi; c++) {
					if(a*a+b*b==c*c){
						System.out.println(a+" "+b+" "+c);
					}
				}
			}
		}

	}
}

