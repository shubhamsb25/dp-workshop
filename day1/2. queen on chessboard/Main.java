import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    
    int count=0;
    int n=8;
    int[] levelQueen=new int[n];
    char[][] grid=new char[n][n];

    public void solve() throws IOException {
        for(int i=0;i<n;i++){
            grid[i]=br.readLine().toCharArray();
        }
        rec(0);
        sb.append(count);
    }
    
    private void rec(int p){
        if(p==n){
            count++;
            return;
        }
        
        for(int i=0;i<n;i++){
            if(grid[p][i]!='*' && !isAttackingQueen(p,i)){
                levelQueen[p]=i;
                rec(p+1);
            }
        }
    }
    
    private boolean isAttackingQueen(int p,int q){
        for(int i=0;i<p;i++){
            int row=i;
            int col=levelQueen[row];
            
            if(col==q){
                return true;
            }
            if(Math.abs(row-p)==Math.abs(col-q)){
                return true;
            }
        }
        return false;
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