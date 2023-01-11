import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int n;
    int[] dp = new int[(int) 2e5 + 1];

    public void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        String winner = rec(n) == 1 ? "Vivek" : "Abhishek";
        sb.append(winner).append("\n");
    }

    // TODO: iterative also giving tle
    private int rec(int givenChips) { // return 1 if wining state, else 0
        if (givenChips <= 0) {
            return 0;
        }
        for (int chips = 1; chips <= givenChips; chips++) {
            dp[chips] = 0;
            for (int i = 1; i <= chips; i <<= 1) {
                if (dp[chips - i] == 0) {
                    dp[chips] = 1;
                    break;
                }
            }
        }
        return dp[givenChips];
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

        Arrays.fill(dp, -1);
        dp[0] = 0;

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