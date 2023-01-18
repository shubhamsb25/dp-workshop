import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int n,k;
    int[] ar;
    int[] dp;

    public void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        ar = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }
        
        dp=new int[n];
        // dp stores cost to reach index i
        dp[0]=0;
        
        for(int i=1;i<n;i++){
            int ctr=k;
            int ans=Integer.MAX_VALUE;
            
            for(int p=i-1;ctr>0 && p>=0;p--,ctr--){
                ans=Math.min(ans, dp[p] + Math.abs(ar[i]-ar[p]));
            }
            
            dp[i]=ans;
        }

        sb.append(dp[n-1]).append("\n");
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
