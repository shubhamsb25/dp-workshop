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
    int mod = 1000000007;

    public void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        dp = new int[n + 1][8];

        for (int i = n; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (i == n) {
                    dp[i][j] = 1;
                } else {
                    if (i > 2 && j == 2) {
                        dp[i][j] = dp[i + 1][5];
                    } else {
                        int sum = dp[i + 1][((j << 1)) & 7] + dp[i + 1][((j << 1) | 1) & 7];
                        sum %= mod;
                        dp[i][j] = sum;
                    }
                }
            }
        }

        // TODO: still giving TLE, need to cache across test cases
        sb.append(dp[0][0]).append("\n");
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