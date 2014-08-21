package freq5;

public class Pow {
	public double pow(double x, int n) {	
		if(x==0)
			return 0;
		return n>=0? powHelper(x, n) : 1/powHelper(x, -n);
    }

	private double powHelper(double x, int n) {
		if(n==0)
			return 1;
		double halfPow = powHelper(x, n/2);
		return n%2==0? halfPow*halfPow : halfPow*halfPow*x;
	}
	
	
}
