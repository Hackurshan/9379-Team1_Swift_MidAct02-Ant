import java.util.ArrayList;
import java.util.List;

public class Hamming {

    public static int hamming(int n) {
        int[] bases = {2, 3, 5};
        int[] expos = {0, 0, 0};
        List<Integer> hamms = new ArrayList<>();
        hamms.add(1);

        for (int i = 1; i < n; i++) {
            int[] nextHamms = new int[3];
            for (int j = 0; j < 3; j++) {
                nextHamms[j] = bases[j] * hamms.get(expos[j]);
            }
            int nextHamm = Math.min(nextHamms[0], Math.min(nextHamms[1], nextHamms[2]));
            hamms.add(nextHamm);

            for (int j = 0; j < 3; j++) {
                if (nextHamms[j] == nextHamm) {
                    expos[j]++;
                }
            }
        }

        return hamms.get(hamms.size() - 1);
    }
}
