package d;

public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if(divisor==1)
			return dividend;
		long dividendlong = Math.abs((long)dividend);
		long divisorlong = Math.abs((long)divisor);
		int ret = 0;
		while(dividendlong>=divisorlong){
			for(int shift = 0; ;shift++){
				if(dividendlong >= divisorlong<<shift){
					dividendlong -= divisorlong<<shift;
					ret += 1<<shift; 
				}else
					break;
			}
		}
		
		return (dividend>=0&&divisor>0||dividend<=0&&divisor<0)? ret : -ret;
    }
	
	public static void main(String args[]){
		new DivideTwoIntegers().divide(-10, 2);
	}
}
