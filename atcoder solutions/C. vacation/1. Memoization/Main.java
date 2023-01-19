import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int n;
    int[] swim;
    int[] bugs;
    int[] homework;

    int[][] dp;

    public void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        swim = new int[n];
        bugs = new int[n];
        homework = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            swim[i] = Integer.parseInt(st.nextToken());
            bugs[i] = Integer.parseInt(st.nextToken());
            homework[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n][3];
        for (int[] a : dp)
            Arrays.fill(a, -1);

        int ans = Math.max(rec(0, 0), Math.max(rec(0, 1), rec(0, 2)));

        sb.append(ans).append("\n");
    }

    private int rec(int level, int last) {// max happiness from [1..n] if start with 'last' activity
        if (level == n) {
            return 0;
        }
        if (dp[level][last] != -1)
            return dp[level][last];

        int ans = 0;
        if (last == 0) {
            ans += swim[level];
            ans += Math.max(rec(level + 1, 1), rec(level + 1, 2));
        } else if (last == 1) {
            ans += bugs[level];
            ans += Math.max(rec(level + 1, 0), rec(level + 1, 2));
        } else {
            ans += homework[level];
            ans += Math.max(rec(level + 1, 0), rec(level + 1, 1));
        }
        return dp[level][last] = ans;
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
        main.singleCaseRunner();
        // main.multipleCaseRunner();
    }
}



