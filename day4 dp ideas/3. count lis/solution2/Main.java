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

    int[] len;
    int[] count;

    public void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        ar = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }

        sb.append(findNumberOfLIS(ar)).append("\n");
    }

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        len = new int[n];
        count = new int[n];

        int maxLengthLIS = -1;

        for (int i = 0; i < n; i++) {
            int curLength = 1;
            int curCount = 1;

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (len[j] + 1 > curLength) {
                        curLength = len[j] + 1;
                        curCount = count[j];
                    } else if (len[j] + 1 == curLength) {
                        curCount += count[j];
                    }
                }
            }
            len[i] = curLength;
            count[i] = curCount;

            maxLengthLIS = Math.max(maxLengthLIS, curLength);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (len[i] == maxLengthLIS) {
                ans += count[i];
            }
        }
        return ans;
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