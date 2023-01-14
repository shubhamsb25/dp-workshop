import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int n;
    int[][] dp;

    public void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        dp = new int[n][5];
        for (int[] a : dp)
            Arrays.fill(a, -1);

        sb.append(rec(0, 0)).append("\n");
    }

    // TODO: fails for long value of n
    private int rec(int level, int state) { // count of strings in which 0100 is not a substring
        if (state == 4) {
            return 0;
        }
        if (level == n) {
            return 1;
        }
        if (dp[level][state] != -1)
            return dp[level][state];

        int ans = 0;
        if (state == 0) {
            ans += rec(level + 1, 1); // if 0
            ans += rec(level + 1, 0); // if 1
        } else if (state == 1) {
            ans += rec(level + 1, 1); // if 0
            ans += rec(level + 1, 2); // if 1
        } else if (state == 2) {
            ans += rec(level + 1, 3); // if 0
            ans += rec(level + 1, 0); // if 1
        } else if (state == 3) {
            ans += rec(level + 1, 4); // if 0
            ans += rec(level + 1, 2); // if 1
        }

        return dp[level][state] = ans;
    }

    private void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    private class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    private void runner(int t) throws IOException {
        while (t != 0) {
            solve();
            t--;
        }
        System.out.println(sb);
    }

    public void multipleCaseRunner() throws IOException {
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        runner(t);
    }

    public void singleCaseRunner() throws IOException {
        runner(1);
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        // main.singleCaseRunner();
        main.multipleCaseRunner();
    }
}
