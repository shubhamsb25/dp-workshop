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
    char[] a,b;
    int[][] dp;
    StringBuilder ans=new StringBuilder();

    public void solve() throws IOException {
        a=br.readLine().toCharArray();
        b=br.readLine().toCharArray();

        n=a.length;
        m=b.length;
        
        dp=new int[n][m];
        for(int[] d:dp)
            Arrays.fill(d,-1);
        
        if(rec(0,0)==0){
            sb.append("");
        }
        else{
            printAns(0,0);
            sb.append(ans.toString());
        }
    }
    
    private int rec(int x,int y){ //lenth of longest common subsequence [x..n] [y..m]
        if(x==n||y==m){
            return 0;
        }
        
        if(dp[x][y]!=-1){
            return dp[x][y];
        }
        int ans=0;
        if(a[x]==b[y]){
            ans=Math.max(ans,1+rec(x+1,y+1));
        }
        ans=Math.max(ans,rec(x,y+1));
        ans=Math.max(ans,rec(x+1,y));
        
        return dp[x][y]=ans;
    }
    
    private void printAns(int x,int y){
        if(x==n||y==m){
            return;
        }
        if(rec(x,y)==rec(x+1,y)){
            printAns(x+1,y);
        }
        else if(rec(x,y)==rec(x,y+1)){
            printAns(x,y+1);
        }
        else{
            ans.append(a[x]);
            printAns(x+1,y+1);
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
        main.singleCaseRunner();
        // main.multipleCaseRunner();
    }
}
