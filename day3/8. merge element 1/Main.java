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
    int[] prefix;
    int[][] dp;

    public void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        ar = new int[n];
        prefix = new int[n + 1];
        dp = new int[500][500];

        for (int[] a : dp)
            Arrays.fill(a, -1);

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
            prefix[i + 1] = prefix[i] + ar[i];
        }
        sb.append(rec(0, n - 1)).append("\n");
    }

    private int rec(int x, int y) {// min cost to merge elements from [x..y]
        if (x == y) {
            return 0;
        }
        if (x + 1 == y) {
            return ar[x] * ar[y];
        }
        if (dp[x][y] != -1)
            return dp[x][y];
        int ans = Integer.MAX_VALUE;
        for (int i = x; i < y; i++) {
            ans = Math.min(ans, rec(x, i) + rec(i + 1, y) + getSum(x, i) * getSum(i + 1, y));
        }
        return dp[x][y] = ans;
    }

    private int getSum(int x, int y) {
        if (x == y) {
            return ar[x];
        } else {
            return (prefix[y + 1] - prefix[x]) % 100;
        }
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