import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int n, m, k;
    int[][] ar;

    // TODO: test case not passing
    public void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
 
        ar = new int[n + 1][m + 1];

        // ref: http://ihaventyetdecided.blogspot.com/2010/10/kadanes-2d-algorithm.html

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                ar[i][j] = Integer.parseInt(st.nextToken());
                ar[i][j] += ar[i - 1][j];
            }
        }

        int[] sum = new int[m + 1];
        int size = 0;
        for (int rowStart = 1; rowStart <= n; rowStart++) {
            for (int rowEnd = rowStart; rowEnd <= n; rowEnd++) {
                int cur = 0;
                int start = 1;

                for (int col = 1; col <= m; col++) {
                    sum[col] = ar[rowEnd][col] - ar[rowStart - 1][col];
                    cur += sum[col];
                    if (cur <= k) {
                        size = Math.max(size, (col - start + 1) * (rowEnd - rowStart + 1));
                    } else {
                        cur = sum[col];
                        start = col;
                    }
                }
            }
        }

        sb.append(size).append("\n");
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



