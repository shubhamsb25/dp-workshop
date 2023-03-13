import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    
    int n,m,k;
    long[][] dp;
    int mod=1000000007;

    public void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        
        dp=new long[n+1][k+1];
        
        dp[1][0]=m;
        
        for(int i=2;i<=n;i++){
            for(int j=0;j<=k;j++){
                if(j==0){
                    dp[i][j]=m;
                }
                else{
                    dp[i][j]=(dp[i-1][j]+((m-1)*dp[i-1][j-1])%mod)%mod;
                }
            }
        }
        
        sb.append(dp[n][k]).append("\n");
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



