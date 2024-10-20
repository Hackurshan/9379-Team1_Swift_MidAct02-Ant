public class Multiplication{
  public static int [][] multiplicationTable(int n){
   int[][] r = new int[n][n];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                r[i-1][j-1] = i * j;
            }
        }
        return r;
    }
}
