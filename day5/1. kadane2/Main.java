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
    int[][] prefix;

    public void solve() throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        
        ar=new int[n][m];
        prefix=new int[n][m];
        
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                ar[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int ans=0;
                if(i>0){
                    ans+=prefix[i-1][j];
                }
                if(j>0){
                    ans+=prefix[i][j-1];
                }
                if(i>0 && j>0){
                    ans-=prefix[i-1][j-1];
                }
                ans+=ar[i][j];
                prefix[i][j]=ans;
            }
        }
        
        // TODO: test case not passing
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int size=0;
                if(i==0 && j==0){
                    if(ar[i][j]<=k){
                        size=1;
                    }
                }
                else{
                    if(j==0){
                        if(prefix[i][j]<=k){
                            size=Math.max(size,i+1);
                        }
                    }
                    else if(i==0){
                        if(prefix[i][j]<=k){
                            size=Math.max(size,j+1);
                        }
                    }
                    else{
                        if(prefix[i][j]<=k){
                            size=Math.max(size,(i+1)*(j+1));
                        }
                        else if(prefix[i][j]-prefix[i][j-1]<=k){
                            size=Math.max(size,i+1);
                        }
                        else if(prefix[i][j]-prefix[i-1][j]<=k){
                            size=Math.max(size,j+1);
                        }
                    }
                }
                
                max=Math.max(max,size);
            }
        }
        
        sb.append(max).append("\n");
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