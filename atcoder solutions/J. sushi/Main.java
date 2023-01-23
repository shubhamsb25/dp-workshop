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
    double[][][] dp;

    public void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        
        ar=new int[n];
        
        dp=new double[n+1][n+1][n+1];
        for(double[][] a:dp)
            for(double[] b:a)
                Arrays.fill(b,-1.0d);
        
        int three=0,two=0,one=0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            ar[i]=Integer.parseInt(st.nextToken());
            if(ar[i]==3){
                three++;
            }
            else if(ar[i]==2){
                two++;
            }
            else{
                one++;
            }
        }
        sb.append(rec(three,two,one));
    }
    
    private double rec(int three,int two,int one){ // expected number of operations for (three,two,one) number of sushi
        if(three<0 || two<0 || one<0){
            return 0;
        }
        
        if(three==0 && two==0 && one==0){
            return 0;
        }
        
        if(dp[three][two][one]!=-1)
            return dp[three][two][one];
        
        double ans=0;
        
        double sum=three+two+one;
        
        ans+=n/sum;
        ans+=(three/sum)*rec(three-1,two+1,one);
        ans+=(two/sum)*rec(three,two-1,one+1);
        ans+=(one/sum)*rec(three,two,one-1);
        return dp[three][two][one]=ans;
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
