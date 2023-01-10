import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int n;
    int[] ar;
    int[][][] dp;

    public void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        ar = new int[n];
        dp = new int[n][n][n];

        for (int[][] a : dp)
            for (int[] b : a)
                Arrays.fill(b, -1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }

        sb.append(rec(0, n - 1, 0)).append("\n");
    }

    // max value by removing [l..r] where remainingMarbles represent number of
    // marbles not deleted yet
    // having same color as l

    // Idea is to chain matching marbles to create large chains which would give max results
    private int rec(int l, int r, int remainingMarbles) {
        if (l > r) {
            return 0;
        }
        if (l == r) {
            int count = remainingMarbles + 1;
            return count * count;
        }
        if (dp[l][r][remainingMarbles] != -1)
            return dp[l][r][remainingMarbles];

        int count = remainingMarbles + 1;
        int ans = (count * count) + rec(l + 1, r, 0);

        for (int i = l + 1; i <= r; i++) {
            if (ar[l] == ar[i]) {
                ans = Math.max(ans, rec(l + 1, i - 1, 0) + rec(i, r, remainingMarbles + 1));
            }
        }

        return dp[l][r][remainingMarbles] = ans;
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