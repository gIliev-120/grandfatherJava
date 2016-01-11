package geometrie;

import java.util.Scanner;

public class Hilfe {
	public static Scanner sc = new Scanner(System.in);
	public static final double EPSILON = 1.0e-4;

	public static boolean equal(double x, double y) {
		if (Math.abs(x - y) < EPSILON) {
			return true;
		} else {
			return false;
		}
	}

	public static double quad(double x) {
		return x * x;
	}

	public static int signum(double x) {
		if (x > Hilfe.EPSILON) {
			return 1;
		} else if (x < Hilfe.EPSILON) {
			return -1;
		} else {
			return 0;
		}

	}

}
