package c;

public class Candy {
	public int candy(int[] ratings) {
		int[] candy = new int[ratings.length];
		
		for(int i = 0; i < candy.length; i++){
			if(i!=0&&ratings[i]>ratings[i-1]){
				candy[i] = candy[i-1]+1;
			}else{
				candy[i] = 1;
			}
		}
		
		for(int i = candy.length-1; i >=0; i--){
			if(i!=candy.length-1&&ratings[i]>ratings[i+1]){
				candy[i] = Math.max(candy[i], candy[i+1]+1);
			}
		}
		
		int ret = 0;
		for(int i : candy){
			ret += i; 
		}
		return ret;
    }
	
	public static void main(String args[]){
		new Candy().candy(new int[]{2,1});
	}
}
