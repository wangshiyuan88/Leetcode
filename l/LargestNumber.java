public class LargestNumber{
  public String largestNumber(int[] num) {

    String[] NUM = new String[num.length];

    for (int i = 0; i < num.length; i++) {
      NUM[i] = String.valueOf(num[i]);
    }

    java.util.Arrays.sort(NUM, new java.util.Comparator<String>() {
      public int compare(String left, String right) {
        String leftRight = left.concat(right);
        String rightLeft = right.concat(left);
        return rightLeft.compareTo(leftRight);
      }
    });

    java.lang.StringBuffer buffer = new java.lang.StringBuffer();
    for (int i = 0; i < NUM.length; i++) {
      buffer.append(NUM[i]);
    }
    // String result = buffer.toString();
    java.math.BigInteger result = new java.math.BigInteger(
    buffer.toString());
    return result.toString();
  }
}
