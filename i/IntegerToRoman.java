package i;

public class IntegerToRoman {
	// 1 ,5 10, 50, 100, 500, 1000
	String[] symbol = new String[]{"I", "V", "X", "L", "C", "D", "M"};
	public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
		int scale = 1000;
        for(int i = 6; i>= 0; i-=2){
        	int digit = num/scale;
        	if(digit!=0){
        		if(digit<=3){
        			for(int j = 0; j < digit; j++){
        				sb.append(symbol[i]);
        			}
        		}
        		else if(digit == 4){
        			sb.append(symbol[i]);
        			sb.append(symbol[i+1]);
        		}else if(digit == 5){
        			sb.append(symbol[i+1]);
        		}else if(digit <=8){
        			sb.append(symbol[i+1]);
        			for(int j =0; j < digit-5; j++){
        				sb.append(symbol[i]);
        			}
        		}else if(digit==9){
        			sb.append(symbol[i+2]);
        			sb.append(symbol[i]);
        		}
        	}
        	num = num%scale;
    		scale/=10;
        }
		return sb.toString();
	}
	
	public  static void main(String[] args){
		new IntegerToRoman().intToRoman(1);
	}
	
}
