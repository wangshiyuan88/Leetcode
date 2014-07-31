package p;

public class pow {
	public double pow(double x, int n) {
    if(n < 0)
    	return 1/powerHelper(x, -n);
    else
    	return powerHelper(x, n);
	}
	
	private double powerHelper(double x, int n){
		if(n == 0)
			return 1;
		
		double halfPower = powerHelper(x, n/2);
		
		if(n%2 == 0)
			return halfPower * halfPower;
		else
			return halfPower * halfPower * x;
	}
}
