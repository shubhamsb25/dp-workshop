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
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        
        ar=new int[n];
        dp=new int[k+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            ar[i]=Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(ar);
        
        for(int i=1;i<=k;i++){
            int ans=0;
            for(int j=0;j<n && ar[j]<=i;j++){
                if(dp[i-ar[j]]==0){
                    ans=1;
                    break;
                }
            }
            dp[i]=ans;
        }
        
        sb.append(dp[k]==1?"First":"Second");
    }
    
    private int rec(int level){ //return 1 if winning state else 0
        if(level<=0){
            return 0;
        }
        
        int ans=0;
        for(int i=0;i<n && ar[i]<=level;i++){
            if(rec(level-ar[i])==0){
                ans=1;
                break;
            }
        }

        return ans;
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



