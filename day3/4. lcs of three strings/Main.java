import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    char[] a, b, c;
    int p, q, r;
    int[][][] dp = new int[100][100][100];

    public void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        a = st.nextToken().toCharArray();
        b = st.nextToken().toCharArray();
        c = st.nextToken().toCharArray();

        p = a.length;
        q = b.length;
        r = c.length;

        for (int[][] a : dp)
            for (int[] b : a)
                Arrays.fill(b, -1);

        int ans = lcs(0, 0, 0);
        sb.append(ans).append("\n");
    }

    private int lcs(int i, int j, int k) {
        if (i == p || j == q || k == r) {
            return 0;
        }

        if (dp[i][j][k] != -1)
            return dp[i][j][k];

        int ans = 0;
        // move ptr for a
        ans = Math.max(ans, lcs(i + 1, j, k));
        // move ptr for b
        ans = Math.max(ans, lcs(i, j + 1, k));
        // move ptr for c
        ans = Math.max(ans, lcs(i, j, k + 1));

        if (a[i] == b[j] && b[j] == c[k]) {
            ans = Math.max(ans, 1 + lcs(i + 1, j + 1, k + 1));
        }

        return dp[i][j][k] = ans;
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
