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
    long[][] dp;
    int mod=(int)1e9+7;

    public void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        
        ar=new int[n+1];
        dp=new long[n+1][k+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            ar[i]=Integer.parseInt(st.nextToken());
        }
        
        // zero candy zero kids only one way
        dp[0][0]=1;
        
        for(int kid=1;kid<=n;kid++){
            for(int candy=0;candy<=k;candy++){
                if(candy>0){
                    dp[kid-1][candy]=(dp[kid-1][candy]+dp[kid-1][candy-1])%mod;
                }
                
                int limit=Math.max(0,candy-ar[kid]);
                
                long ways=dp[kid-1][candy];
                
                if(limit>0){
                    //we have taken mod, so reducing can make it less than zero
                    ways-=dp[kid-1][limit-1];
                    if(ways<0){
                        ways+=mod;
                    }
                }
                
                dp[kid][candy]=ways;
            }
        }
        
        sb.append(dp[n][k]);
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
