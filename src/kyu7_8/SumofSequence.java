package kyu7_8;

public class SumofSequence {
    public static int sequenceSum(int start, int end, int step) {
        int count = 0;
            for (int i = start; i <= end; i += step) {
                count += i;
            }
            return count;
        }    
    
}
