package freq3;

public class DivideTwoIntegers {
	 public int divide(int dividend, int divisor) {
		 int ret = 0;
		 long abs_dividend = Math.abs((long)dividend);
		 long abs_divisor = Math.abs((long)divisor);
		 while(abs_dividend>=abs_divisor){
			 for(long temp = abs_divisor, shift = 0; (temp<<shift)<=abs_dividend; shift++){
				 abs_dividend -= temp<<shift;
				 ret += 1<<shift;
			 }
		 }
		 return (dividend>=0&&divisor<0)||(dividend<=0&&divisor<0)? -ret: ret;
	 }
	 
	 public static void main(String args[]){
		 System.out.println(new DivideTwoIntegers().divide(-10, 2));
	 }
}
