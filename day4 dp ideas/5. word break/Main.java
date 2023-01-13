import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int n;
    String sentence;
    Set<String> words;
    int[] dp;

    public void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        sentence = br.readLine();

        dp = new int[sentence.length()];
        Arrays.fill(dp, -1);

        words = new HashSet<>();

        for (int i = 0; i < n; i++) {
            words.add(br.readLine());
        }

        String ans = dp(sentence.length() - 1) == 1 ? "YES" : "NO";
        sb.append(ans).append("\n");
    }

    // TODO: TCs are failing
    private int dp(int level) { // possible to create sentence using given words till [0..level]
        if (level < 0) {
            return 1;
        }

        if (dp[level] != -1)
            return dp[level];

        int lower = Math.max(0, level - 19);
        int ans = 0;
        String sb = "";
        for (int i = level; i >= lower; i--) {
            sb = sentence.charAt(i) + sb;
            if (words.contains(sb) && dp(i - 1) == 1) {
                ans = 1;
                break;
            }
        }
        return dp[level] = ans;
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
