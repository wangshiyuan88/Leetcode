package freq4;

public class SqrtX {
	  public int sqrt(int x) {
		  double current = x;
		  double prev = 0;
		  while(prev>current){
			  prev = current;
			  current = (prev+x/prev)/2;
		  }
		  	return (int)current;
	  }
}
