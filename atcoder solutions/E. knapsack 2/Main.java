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
    
    long[][] dp;

    public void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        weight=new int[n];
        value=new int[n];
        
        dp=new long[100010][n];
        
        for(long[] a:dp)
            Arrays.fill(a,-1);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            
            weight[i]=Integer.parseInt(st.nextToken());
            value[i]=Integer.parseInt(st.nextToken());
        }
        
        long maxVal=Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<=100000;j++){
                long weight=rec(i,j);
                if(weight<=w){
                    maxVal=Math.max(maxVal,j);
                }
            }
        }
        sb.append(maxVal).append("\n");
    }

    private long rec(int level, int valueToCreate) { //min weight required to create value in [level..n]
        if (level == n) {
            if(valueToCreate==0){
                return 0;
            }
            else{
                return Integer.MAX_VALUE;
            }
        }
        
        if(dp[valueToCreate][level]!=-1){
            return dp[valueToCreate][level];
        }
        
        long ans=rec(level+1,valueToCreate);
        if(value[level]<=valueToCreate){
            ans=Math.min(ans,weight[level]+rec(level+1,valueToCreate-value[level]));
        }
        return dp[valueToCreate][level]=ans;
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



