package freq4;

public class ReverseInteger {
	public int reverse(int x) {
		int ret = 0;
		while(x!=0){
			ret = ret*10+x%10;
			x/=10;
		}
		return ret;
    }
}
