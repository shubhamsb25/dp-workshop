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
    
    List<Integer>[] adj;
    int[] dp;

    public void solve() throws IOException {
        st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        
        adj=new ArrayList[n];
        dp=new int[n];
        Arrays.fill(dp,-1);
        
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            
            adj[s-1].add(e-1);
        }
        
        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,rec(i));
        }
        
        sb.append(ans);
    }
    
    private int rec(int x){ //longest path starting at node x
        if(dp[x]!=-1)
            return dp[x];
            
        int ans=0;
        for(int a:adj[x]){
            ans=Math.max(ans,1+rec(a));
        }
        return dp[x]=ans;
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
