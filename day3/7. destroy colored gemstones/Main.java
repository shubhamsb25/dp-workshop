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
    int[][] dp;
    int inf = 1000;

    public void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        ar = new int[n];
        dp = new int[100][100];

        for (int[] a : dp)
            Arrays.fill(a, -1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }
        sb.append(rec(0, n - 1)).append("\n");
    }

    /**
     * We are trying to remove regions
     * But the trick is to take first or last element and see when it will be removed
     * Let's take first element
     * If matches with last element -> we can reduce problem space by [i+1,j-1]
     * If matches with some intermediate element [i+1..j-1] -> we can break problem into two [i,x] [x+1,j]
     * If does not match, we will have to remove it singly -> problem reduces to 1+[i+1,j]
     */
    private int rec(int x, int y) { // min cost to destroy gems from [x..y]
        if (x + 1 == y) {
            if (ar[x] == ar[y]) {
                return 1;
            } else {
                return 2;
            }
        }
        if (x == y) {
            return 1;
        }
        if (dp[x][y] != -1)
            return dp[x][y];

        int ans = inf;
        // if matches with ending element
        if (ar[x] == ar[y]) {
            ans = Math.min(ans, rec(x + 1, y - 1));
        }
        // if matches with any element [x+1..y-1]
        for (int i = x + 1; i < y; i++) {
            if (ar[x] == ar[i]) {
                ans = Math.min(ans, rec(x, i) + rec(i + 1, y));
            }
        }
        // if does not match, try removing directly
        ans = Math.min(ans, 1 + rec(x + 1, y));
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