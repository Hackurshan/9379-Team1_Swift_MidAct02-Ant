import java.util.Arrays;

public class Smaller {
   
public static int[] smaller(int[] arr) {
int n = arr.length;
int[] result = new int[n];

int min = Arrays.stream(arr).min().orElse(Integer.MAX_VALUE);
int max = Arrays.stream(arr).max().orElse(Integer.MIN_VALUE);

int[] count = new int[max - min + 1];

for (int i = n - 1; i >= 0; i--) {
int num = arr[i];
int adjustedNum = num - min;

// Count the number of elements smaller than the current element
for (int j = adjustedNum - 1; j >= 0; j--) {
result[i] += count[j];
}
// Increment counter for current element
count[adjustedNum]++;
}
return result;
}
}
