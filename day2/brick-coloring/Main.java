import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    long n, m, k;
    long[][] dp = new long[2000][2000];
    int mod = 1000000007;

    public void solve() throws IOException {
        for (long[] a : dp)
            Arrays.fill(a, -1);

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        sb.append(rec(0, 0)).append("\n");
    }

    private long rec(int level, int wallsWithDifferentColor) {
        if (level == n) {
            if (wallsWithDifferentColor == k) {
                return 1;
            } else {
                return 0;
            }
        }
        if (dp[level][wallsWithDifferentColor] != -1) {
            return dp[level][wallsWithDifferentColor];
        }
        if (level == 0) {
            return (m * rec(level + 1, wallsWithDifferentColor)) % mod;
        } else {
            long ways = 0;
            // make same color as prev
            ways += rec(level + 1, wallsWithDifferentColor);
            // make diff color than prev
            if (wallsWithDifferentColor + 1 <= k) {
                ways += (m - 1) * rec(level + 1, wallsWithDifferentColor + 1);
            }
            ways %= mod;
            return dp[level][wallsWithDifferentColor] = ways;
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
        // main.singleCaseRunner();
        main.multipleCaseRunner();
    }
}
