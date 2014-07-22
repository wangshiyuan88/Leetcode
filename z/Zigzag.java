package z;

public class Zigzag {
	    public static String convert(String s, int nRows) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	       
	    	if(nRows==1)
	            return s;
	    	char[][] matrix = new char[nRows][s.length()];
	        for(int i = 0;i<matrix.length;i++){
	            for(int j=0; j<matrix[0].length;j++){
	                matrix[i][j]='\0';
	            }
	        }
	        int r = 0;
	        int l = 0;
	        int n = 0;
	        while(n<s.length()){
	            while(r<nRows&&n<s.length()){
	                matrix[r++][l]=s.charAt(n++);
	                //n++;
	            }
	            r--;
	            while(r>0&&n<s.length()){
	                r--;
	                l++;
	                matrix[r][l]=s.charAt(n++);
	            }
	            r++;
	        }
	        StringBuilder result = new StringBuilder();
	        for(int i = 0;i<matrix.length;i++){
	            for(int j=0; j<matrix[0].length;j++){
	                if(matrix[i][j]!='\0'){
	                   result.append(matrix[i][j]);
	                }
	            }
	        }
	        return result.toString();
	    }
}
