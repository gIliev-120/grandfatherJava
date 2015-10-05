import java.util.Scanner;

public class Q {
	public static Scanner st = new Scanner(System.in);
	public static final double EPSILON = 1.0e-4;

	public static void main(String[] args) {
			double a,b,c;
			double x1=0;
			double x2=0;
			double x=0;
			
			a= st.nextDouble();
			b= st.nextDouble();
			c= st.nextDouble();
			
			if(Math.abs(a)>EPSILON){
				double discriminant = b*b -4*a*c;
				System.out.println("discriminant="+discriminant);
				if(Math.abs(discriminant)>EPSILON){
					if(discriminant<0){
						System.out.println("Imaginere Werte !");
					}else if(discriminant>=0){
						
						double wurzel = Math.sqrt(discriminant);
						x1=(-b+wurzel)/(2*a);
						x2=(-b-wurzel)/(2*a);
						System.out.println("Zwei Loesungen "+"x1="+x1+" "+"x2="+x2);
						
					}else{
						x=-b/(2*a);
						System.out.println("eine losung"+x);
					}
				}else{
					if(Math.abs(b)>EPSILON){
						x=-b/(2*a);
						 System.out.println(x);
						 
					}else if(Math.abs(c)>EPSILON){
						System.out.println("Keine Losungen");
						
					}else{
						
						System.out.println("Unendlich viele Loesungen");
					}
				}
			}
			
		} 
}
