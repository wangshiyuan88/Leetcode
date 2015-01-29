public class FindPeakElement{
  public int findPeakElement(int[] num) {
        int n = num.length;
        if(n == 1)
            return 0;
        int start = 0;
        int end = n-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if((mid==0||num[mid-1]<num[mid])&&(mid==num.length-1||num[mid]>num[mid+1]))
                return mid;
            else if(mid>0&&num[mid]<num[mid-1])
                end = mid-1;
            else
                start = mid+1;
        }
        return 0;
    }
}
