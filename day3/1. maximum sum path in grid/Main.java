import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int n, m;
    int[][] ar;
    long[][] dp;

    public void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ar = new int[n][m];

        dp = new long[n][m];

        for (long[] a : dp) {
            Arrays.fill(a, -1);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ar[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long ans = rec(n - 1, m - 1);
        sb.append(ans).append("\n");
    }

    private long rec(int x, int y) { // max path sum ending at (x,y)
        if (x < 0 || y < 0) {
            return 0;
        }

        if (dp[x][y] != -1)
            return dp[x][y];

        long ans = ar[x][y] + rec(x - 1, y);
        ans = Math.max(ans, ar[x][y] + rec(x, y - 1));
        return dp[x][y] = ans;
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
