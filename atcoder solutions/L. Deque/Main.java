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
    long[][] dp;

    public void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        
        ar=new int[n];
        dp=new long[n][n];
        
        for(long[] a:dp)
            Arrays.fill(a,Long.MIN_VALUE);
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            ar[i]=Integer.parseInt(st.nextToken());
        }
        
        sb.append(rec(0,n-1));
    }
    
    private long rec(int start,int end){ // max possible value of my (point-others point) if I am playing on this level
        if(start>end){
            return Long.MIN_VALUE;
        }
        //if single is left
        if(start==end){
            return ar[start];
        }
        //if two are left
        if(start+1==end){
            return Math.abs(ar[start]-ar[end]);
        }
        
        if(dp[start][end]!=Long.MIN_VALUE)
            return dp[start][end];
        
        // have to do (my-(other-my)) as rec gives (other-my)
        long ans=Math.max(ar[start]-rec(start+1,end),ar[end]-rec(start,end-1));
        return dp[start][end]=ans;
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
