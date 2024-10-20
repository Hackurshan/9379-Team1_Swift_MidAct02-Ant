package kyu7_8;
class MinMax {
    public static int[] minMax(int[] arr) {
 int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    for (int num : arr) {
        if (num < min) {
            min = num;
        }
        if (num > max) {
            max = num;
        }
    }

    return new int[] { min, max };
    }
}
