package n;

public class NextPermutation {
	  public void nextPermutation(int[] num) {
		  int after = Integer.MIN_VALUE;
		  int index = -1;
		  for(int i = num.length-1; i >= 0; i--){
			  int current = num[i];
			  if(current < after){
				  index = i;
				  break;
			  }
			  after = current;
		  }
		  if(index != -1){
			for(int i = num.length-1; i >index; i--){
				if(num[index]<num[i]){
					int tmp = num[index];
					num[index] = num[i];
					num[i] = tmp;
					break;
				}
			}
		  }
		  reverse(num, index+1);	// Just reverse the order, you don't have to use sort function to reverse it.
	   }
	  
	  
	  private void reverse(int[] num, int start){
		 int end = num.length-1;
		 while(start < end){
			 int tmp = num[start];
			 num[start] = num[end];
			 num[end] = tmp;
			 start++;
			 end--;
		 }
	  }
	  
	  public static void main(String[] args){
		  int [] num = new int[]{5,3,9,4,5};
		new NextPermutation().nextPermutation(num);
		System.out.println(num);
	  }
}
