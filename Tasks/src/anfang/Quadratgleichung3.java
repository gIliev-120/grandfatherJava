package anfang;
import java.util.Scanner;


public class Quadratgleichung3 {
	static Scanner st = new Scanner(System.in);
	public static void main(String[] args) {
		double a,b,c,d,disk,x,x1,x2,t;
		do{
			a=st.nextDouble();
			b=st.nextDouble();
			c=st.nextDouble();
			
			if(a!=0){
				disk=(b*b)-(4*a*c);
				System.out.println(disk);
				if(disk>=0){
					t=Math.sqrt(disk);
					x1=(-b+t)/(2*a);
					x2=(-b-t)/(2*a);
					System.out.println("x1= "+x1+" "+"x2= "+x2);
				}else{
						System.out.println("Imaginare Werte ");
				}
			}else if(b!=0){
				x=-c/b;
				System.out.println("Ein Wurzel x= "+x);
			}else if(c!=0){
				System.out.println("Keine Werte");
			}else{
				System.out.println("Viele Werte");
			}
		}while(!(a==0&&b==0&&c==0));
		System.out.println("GOOD BYE");
		
	}
}
