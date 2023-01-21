import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int n;
    int m;
    char[][] ar;
    int mod=1000000007;
    
    int[][] dp;

    public void solve() throws IOException {
        st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        
        ar=new char[n][m];
        dp=new int[n][m];
        for(int[] a:dp)
            Arrays.fill(a,-1);
        
        for(int i=0;i<n;i++){
            ar[i]=br.readLine().toCharArray();
        }
        
        sb.append(rec(n-1,m-1));
    }
    
    private int rec(int x,int y){ //number of ways to reach [x,y] from [0,0]
        if(x<0 || y<0){
            return 0;
        }
        if(ar[x][y]=='#'){
            return 0;
        }
        if(x==0 && y==0){
            return 1;
        }
        
        if(dp[x][y]!=-1)
            return dp[x][y];
            
        int ways=0;
        ways+=rec(x,y-1);
        ways+=rec(x-1,y);
        
        if(ways>mod){
            ways%=mod;
        }
        return dp[x][y]=ways;
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
