public class MaxProduct{
  public int maxProduct(int[] A) {
    int max = A[0];
    int min = A[0];
    int ret = A[0];
    for(int i = 1; i < A.length; i++){
      int temp = max;
      max = Math.max(A[i],Math.max(max*A[i], min*A[i]));
      min = Math.min(A[i],Math.min(min*A[i],temp*A[i]));
      ret = Math.max(max, ret);
    }
    return ret;
  }
}
