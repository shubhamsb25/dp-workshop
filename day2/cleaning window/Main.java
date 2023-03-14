import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    
    int n,m,k;
    int[][] ar;
    int mod=1000000007;
    int[][] dp;

    public void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        
        ar=new int[n][m];
        dp=new int[n][m];
        
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                ar[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0;i<m;i++){
            dp[0][i]=ar[0][i];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=ar[i][j];
                dp[i][j]=Math.max(dp[i][j],dp[i-1][j]);
                if(j!=0){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-1]);
                }
                if(j!=m-1){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j+1]);
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               if(dp[i][j]>ar[i][j]){
                    dp[i][j]=0;
                }
                else{
                    dp[i][j]=1;
                }
            }
        }
        
        for(int[] res:dp){
            for(int a:res){
                sb.append(a);
            }
            sb.append("\n");
        }
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
