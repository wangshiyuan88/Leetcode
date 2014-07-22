package g;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	 public List<Integer> grayCode(int n) {
		 if(n==0){
			 List<Integer> ret = new ArrayList<Integer>();
			 ret.add(0);
			 return ret;
		 }
		 List<Integer> lastRet = grayCode(n-1);
		 for(int i = lastRet.size()-1; i >=0; i--){
			 lastRet.add((int) (lastRet.get(i)+Math.pow(2, n-1)));
		 }
		 return lastRet;
	 }
}
