import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    
    int n,k;
    long[] ar;
    long[] prefix;
    
    long[][] dp;

    public void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        
        ar=new long[n];
        prefix=new long[n];
        
        dp=new long[n][n];
        
        for(long[] a:dp)
            Arrays.fill(a,-1);
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            ar[i]=Integer.parseInt(st.nextToken());
            prefix[i]=ar[i];
        }
        
        for(int i=1;i<n;i++){
            prefix[i]+=prefix[i-1];
        }
        
        sb.append(rec(0,n-1));
    }
    
    private long rec(int l,int r){
        if(l==r){
            return 0;
        }
        if(l+1==r){
            return ar[l]+ar[r];
        }
        
        if(dp[l][r]!=-1){
            return dp[l][r];
        }
        
        long rangeSum=prefix[r];
        if(l>0){
            rangeSum-=prefix[l-1];
        }
        long cost=Long.MAX_VALUE;
        for(int i=l;i<r;i++){
            cost=Math.min(cost,rec(l,i)+rec(i+1,r));
        }
        return dp[l][r]=cost+rangeSum;
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
