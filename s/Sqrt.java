package s;

public class Sqrt {
    public int sqrt(int x) {
       if(x==0)
    	   return 0;
       double current = x;
       double last = 0;
       do{
    	  last = current;
    	  current = (last+x/last)/2;

       }while(current<last);
       return (int) current;
    }
}
