import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    char[] a,b;
    int n,m;
    
    int[][] dp=new int[1000][1000];
    
    public void solve() throws IOException {
        for(int[] a:dp)
            Arrays.fill(a,-1);
        
        st = new StringTokenizer(br.readLine());
        a=st.nextToken().toCharArray();
        b=st.nextToken().toCharArray();
        n=a.length;
        m=b.length;
        
        int max=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++){
                max=Math.max(max,rec(i,j));
            }
        
        sb.append(max).append("\n");
    }
    
    private int rec(int x,int y){ //longest common substring starting at x and y
        if(x==n || y==m){
            return 0;
        }
        if(dp[x][y]!=-1)
            return dp[x][y];
        
        int ans=0;
        if(a[x]==b[y]){
            ans = 1+rec(x+1,y+1);
        }
        else{
            ans = 0;
        }
        return dp[x][y]=ans;
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
