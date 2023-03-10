import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int n;
    int q;
    int[] ar;
    int[] queries;
    boolean[][] dp;

    public void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        q=Integer.parseInt(st.nextToken());

        ar=new int[n];
        queries=new int[q];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            ar[i]=Integer.parseInt(st.nextToken());
        }

        int max=-1;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<q;i++){
            queries[i]=Integer.parseInt(st.nextToken());
            max=Math.max(max,queries[i]);
        }

        dp=new boolean[101][max+1];

        for(int level=0;level<=n;level++){
            for(int sum=0;sum<=max;sum++){
                if(sum==0){
                    dp[level][sum]=true;
                }
                else{
                    if(level==0){
                        dp[level][sum]=false;
                    }
                    else{
                        if(sum-ar[level-1]>=0){
                            dp[level][sum]=dp[level-1][sum-ar[level-1]] | dp[level-1][sum];
                        }
                        else{
                            dp[level][sum]=dp[level-1][sum];
                        }
                    }
                }
            }
        }

        for(int q:queries){
            if(dp[n][q]){
                printAns(n,q);
            }
            else{
                sb.append("-1\n");
            }
        }
    }

    private void printAns(int n,int query){
        if(n==0){
            sb.append("\n");
            return;
        }
        if(dp[n-1][query]){
            printAns(n-1,query);
        }
        else{
            int val=ar[n-1];
            sb.append(val).append(" ");
            printAns(n-1,query-val);
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

/*
Idea:

dp[level][sum] gives true if sum can be made with elements till level [0..level]

dp[level][sum]=  will be true if

dp[level-1][sum-val[level]] is true -> take element at level

or 

dp[level-1][sum] is true -> dont take element at level

*/