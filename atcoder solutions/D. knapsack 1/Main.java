import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int n,w;
    int[] weight;
    int[] value;
    
    long[][]dp;

    public void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        weight=new int[n];
        value=new int[n];
        
        dp=new long[n][w+1];
        
        for(long[] a:dp)
            Arrays.fill(a,-1);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            
            weight[i]=Integer.parseInt(st.nextToken());
            value[i]=Integer.parseInt(st.nextToken());
        }
        
        sb.append(rec(0,0));
    }

    private long rec(int level, int taken) {// max happiness from [1..n] if start with 'last' activity
        if (level == n) {
            return 0;
        }
        
        if(dp[level][taken]!=-1)
            return dp[level][taken];
        
        long ans=0;
        ans=Math.max(ans,rec(level+1,taken));
        if(taken+weight[level]<=w){
            ans=Math.max(ans, value[level] + rec(level+1,taken+weight[level]));
        }
        return dp[level][taken]=ans;
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



