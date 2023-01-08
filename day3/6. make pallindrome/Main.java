import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    char[] a;
    int[][] dp = new int[1000][1000];

    public void solve() throws IOException {
        for (int[] a : dp)
            Arrays.fill(a, -1);

        st = new StringTokenizer(br.readLine());
        a = st.nextToken().toCharArray();
        sb.append(rec(0, a.length - 1)).append("\n");
    }

    private int rec(int i, int j) { // min chars to add to create pallindrome from chars [i..j]
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != -1)
            return dp[i][j];

        int ans = Integer.MAX_VALUE;
        if (a[i] == a[j]) {
            ans = Math.min(ans, rec(i + 1, j - 1));
        } else {
            ans = Math.min(ans, 1 + Math.min(rec(i + 1, j), rec(i, j - 1)));
        }
        return dp[i][j] = ans;
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
