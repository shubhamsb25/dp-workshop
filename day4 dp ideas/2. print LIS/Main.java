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
    List<Integer> lis = new ArrayList<>();
    int[] insertedAt;

    public void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        ar = new int[n];
        insertedAt = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }
        rec();
        sb.append(printLIS()).append("\n");
    }

    private int rec() { // return len of lis
        for (int i = 0; i < n; i++) {
            if (lis.isEmpty() || ar[i] > lis.get(lis.size() - 1)) {
                lis.add(ar[i]);
                insertedAt[i] = lis.size();
            } else {
                int index = lowerBound(ar[i]);
                lis.set(index, ar[i]);
                insertedAt[i] = index + 1;
            }
        }
        return lis.size();
    }

    private List<Integer> printLIS() {
        List<Integer> ans = new ArrayList<>();
        int size = lis.size();

        for (int i = n - 1; i >= 0; i--) {
            if (insertedAt[i] == size) {
                ans.add(ar[i]);
                size--;
            }
        }
        Collections.reverse(ans);
        return ans;
    }

    private int lowerBound(int val) {
        int l = 0;
        int h = lis.size() - 1;

        int lowerBound = -1;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            int valAtMid = lis.get(mid);

            if (valAtMid >= val) {
                lowerBound = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return lowerBound;
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
        main.singleCaseRunner();
        // main.multipleCaseRunner();
    }
}