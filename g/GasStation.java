package g;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int total = 0;
		int remainGas = 0;
		int startIndex = 0;
		for(int i = 0; i < gas.length; i++){
			int current = gas[i] - cost[i];
			total += current;
			if(remainGas+current<0){
				startIndex = i+1;
				remainGas = 0;
			}else{
				remainGas += current;
			}
		}
		return total>=0? startIndex : -1;
    }
}
