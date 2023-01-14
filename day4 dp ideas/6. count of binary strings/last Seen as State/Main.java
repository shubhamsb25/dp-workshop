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

        dp = new int[n][8];
        for (int[] a : dp)
            Arrays.fill(a, -1);

        sb.append(rec(0, 0)).append("\n");
    }

    private int rec(int level, int lastThree) { // count of strings in which 0100 is not a substring
        // idea is to use last seen 3 characters
        // so we wont go in state which leads to 0100 (i.e. 010 + '0')
        if (level == n) {
            return 1;
        }

        if (dp[level][lastThree] != -1) {
            return dp[level][lastThree];
        }

        int ans = 0;
        if (level > 2 && lastThree == 2) {
            // if last seen is 010 (not 10)
            ans += rec(level + 1, 5);
        } else {
            ans += rec(level + 1, (lastThree << 1) & 7);
            ans += rec(level + 1, ((lastThree << 1) | 1) & 7);
        }
        ans %= mod;

        return dp[level][lastThree] = ans;
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