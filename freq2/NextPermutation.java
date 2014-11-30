package freq2;

public class NextPermutation {
	  public void nextPermutation(int[] num) {
			if(num==null|num.length<=1)
				return;
			int after = Integer.MIN_VALUE;
			int index;
			for(index = num.length-1; index >= 0; index--){
				int current = num[index];
				if(current<after){
					break;
				}
				else
					after = current;
			}
			if(index == -1){
				reverse(num, 0, num.length-1);
			}else{
				for(int i = num.length-1; i > index; i--){
					if(num[i]>num[index]){
						int tmp = num[index];
						num[index] = num[i];
						num[i] = tmp;
						reverse(num, index+1, num.length-1);
						break;
					}
				}
			
			}
	    }
		public void reverse(int[] num, int start, int end){
			while(start<end){
				int temp = num[start];
				num[start] = num[end];
				num[end] = temp;
				start++;
				end--;
			}
		}
}
