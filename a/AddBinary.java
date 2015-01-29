package a;

public class AddBinary {
	 public static String addBinary(String a, String b) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        StringBuilder result = new StringBuilder();
	        StringBuilder sb1 = new StringBuilder(a);
	        StringBuilder sb2 = new StringBuilder(b);
	        fillWithPadding(sb1, sb2);
	        add(result, sb1.toString(), sb2.toString(), -1);
	        return result.toString();

	    }
	    private static void fillWithPadding(StringBuilder sb1, StringBuilder sb2){
	        int difference = sb1.length()-sb2.length();

	        if(difference>0){
	            while(difference>0){
	                sb2.insert(0,"0");
	                difference--;
	            }
	        }else{
	            while(difference<0){
	                sb1.insert(0,"0");
	                difference++;
	            }
	        }

	    }

	    private static int add(StringBuilder temp, String a, String b, int index){
	        if(index == a.length()-1){
	            if(a.charAt(index)=='1'&&b.charAt(index)=='1'){
	            	temp.append("0");
	                return 1;
	            }else if(a.charAt(index)=='1'||b.charAt(index)=='1'){
	            	temp.append("1");
	                return 0;
	            }else{
	            	temp.append("0");
	                return 0;
	            }
	        }

	       int carry = add(temp, a, b, index+1);
	       if(index==-1){
	    	   if(carry==1)
	    	   temp.insert(0,carry);
	    	   return carry;
	       }

	       if(a.charAt(index)=='1'&&b.charAt(index)=='1'){
	           if(carry==1){
	               temp.insert(0,'1');
	               return 1;
	           }
	           else{
	               temp.insert(0,'0');
	               return 1;
	           }
	       }else if(a.charAt(index)=='1'||b.charAt(index)=='1'){
	           if(carry==1){
	               temp.insert(0,'0');
	               return 1;
	           }else{
	               temp.insert(0,'1');
	               return 0;
	           }
	       }else{
	            if(carry==1){
	               temp.insert(0,'1');
	               return 0;
	           }else{
	               temp.insert(0,'0');
	               return 0;
	           }
	       }
	    }
}
