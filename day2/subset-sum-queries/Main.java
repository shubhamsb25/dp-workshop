import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    
    int n;
    int[] ar;
    int q;
    int sum;
    int[][] dp=new int[100][100000];
    StringBuilder ans;

    public void solve() throws IOException {
        for(int[] a:dp)
            Arrays.fill(a,-1);
        
        st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        
        ar=new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            ar[i]=Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        q=Integer.parseInt(st.nextToken());
        
        for(int i=0;i<q;i++){
            ans=new StringBuilder();
            st = new StringTokenizer(br.readLine());
            sum=Integer.parseInt(st.nextToken());
            
            printAns(0,sum);
            sb.append(ans);
        }
    }
    
    private int rec(int level,int req){
        if(req<0){
            return 0;
        }
        if(level==n){
            if(req==0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[level][req]!=-1){
            return dp[level][req];
        }
        
        int ans=0;
        if(rec(level+1,req)==1){
            ans=1;
        }
        else if(rec(level+1,req-ar[level])==1){
            ans=1;
        }
        return dp[level][req]=ans;
    }
    
    private void printAns(int level,int req){
        if(level==n){
            ans.append("\n");
            return;
        }
        if(rec(level,req)==1){
            if(rec(level+1,req)==1){
                printAns(level+1,req);
            }
            else{
                ans.append(level).append(" ");
                printAns(level+1,req-ar[level]);
            }
        }
        else{
            ans.append("-1").append("\n");
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