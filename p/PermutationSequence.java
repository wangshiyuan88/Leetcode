package p;

public class PermutationSequence {
//  dfs won't work!
//	int counter = 0;
//	String ret = null;
//	public String getPermutation(int n, int k) {
//		getPermutationHelper(n, k, new StringBuilder());
//		return ret;   
//    }
//	
//	public void getPermutationHelper(int n, int k, StringBuilder current){
//		if(ret!=null)
//			return;
//		if(current.length()==n){
//			counter++;
//			if(counter==k)
//				ret = current.toString();
//		}else{
//			for(int i = 1; i <=n ; i++){
//				if(current.indexOf(String.valueOf(i))!=-1){
//					current.append(String.valueOf(i));
//					getPermutationHelper(n, k, current);
//				}
//			}
//		}
//		if(current.length()!=0){
//			current.deleteCharAt(current.length()-1);
//		}
//	}
	
	public String getPermutation(int n, int k) {
        int numberOfWays = 1;
        int[] num = new int[n];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < num.length; i++){
        	num[i] = i+1;
        	numberOfWays *= (i+1); 
        }
        int temp = k-1; 
        for(int i = n; i >= 1; i--){
        	numberOfWays /= i;
        	int index = temp/numberOfWays;
        	temp %= numberOfWays;
        	sb.append(num[index]);
        	for(int j = index+1; j < num.length-(n-i); j++){
        		num[j-1] = num[j];
        	}
        }
		return sb.toString();
    }
	public static void main(String args[]){
		new PermutationSequence().getPermutation(2, 1);
	}
}
