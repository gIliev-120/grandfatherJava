package geometrie;

public class Punkt {
	protected double x, y;
	
	public Punkt() {
		x=0;
		y=0;
	}
	
	public Punkt(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Punkt(Punkt p){
		x=p.x;
		y=p.y;
	}

	public static double fun(double x) {
		double y = 3 * x - 5;

		return y;
	}

	public void eingabe() {
		System.out.println("Eingabe fuer einen Punkt");
		System.out.println("Eingabe von x=");
		x = Hilfe.sc.nextDouble();
		System.out.println("Eingabe von y=");
		y = Hilfe.sc.nextDouble();
	}

	public void move(double delx, double dely) {
		x += delx;
		y += dely;
	}

	public Punkt moveNew(double delx, double dely) {
		double xp = x + delx;
		double yp = y + dely;
		return new Punkt(xp, yp);
	}
	
	public boolean equal(Punkt p){
		if(Hilfe.equal(this.x, p.y)&& Hilfe.equal(this.y, p.y)){
			return true;
		}else{
			return false;
		}
	}

	public String toString() {
		return "Punkt [x=" + x + ", y=" + y + "]";
	}
	
	public void ausgabe(){
		System.out.println(this);
	}
}
