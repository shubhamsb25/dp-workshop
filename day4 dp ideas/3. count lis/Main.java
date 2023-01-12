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
    Pair[] dp;

    public void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        ar = new int[n];
        dp = new Pair[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new Pair(-1, -1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }

        rec(n - 1);

        Pair ans = new Pair(0, 0);

        for (int i = 0; i < n; i++) {
            if (rec(i).x > ans.x) {
                ans.x = rec(i).x;
                ans.y = rec(i).y;
            } else if (rec(i).x == ans.x) {
                ans.y += rec(i).y;
            }
        }
        sb.append(ans.y).append("\n");
    }

    // TODO: giving wrong ans on some TCs
    private Pair rec(int level) { // return (len,count) of lis ending at level
        if (dp[level].x != -1) {
            return dp[level];
        }
        for (int i = 0; i <= level; i++) {
            Pair ans = new Pair(1, 1);

            for (int j = 0; j < i; j++) {
                if (ar[j] < ar[i]) {
                    Pair prev = dp[j];
                    int prevLen = prev.x;
                    int prevCount = prev.y;

                    if (prevLen + 1 > ans.x) {
                        ans.x = prevLen + 1;
                        ans.y = prevCount;
                    } else if (prevLen + 1 == ans.x) {
                        ans.y++;
                    }
                }
            }
            dp[i] = ans;
        }
        return dp[level];
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

        @Override
        public String toString() {
            return "[" + x + "," + y + "]";
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