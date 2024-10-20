package kyu1_2;

import java.util.*;

public class SquareSums {

    public static List<Integer> buildUpTo(int n) {
        Set<Integer> squares = new HashSet<>();
        int maxSquare = 2 * n;
        for (int i = 1; i * i <= maxSquare; i++) {
            squares.add(i * i);
        }

        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[n + 1];
        
        if (backtrack(n, squares, used, path)) {
            return path;
        }
        
        return null;
    }

    private static boolean backtrack(int n, Set<Integer> squares, boolean[] used, List<Integer> path) {
        if (path.size() == n) {
            return true;
        }
        
        int last = path.isEmpty() ? 0 : path.get(path.size() - 1);
        
        for (int num = 1; num <= n; num++) {
            if (!used[num] && (path.isEmpty() || squares.contains(last + num))) {
                used[num] = true;
                path.add(num);
                
                if (backtrack(n, squares, used, path)) {
                    return true;
                }
                
                path.remove(path.size() - 1);
                used[num] = false;
            }
        }
        
        return false;
    }
}

