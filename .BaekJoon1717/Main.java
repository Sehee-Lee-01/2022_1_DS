import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] p = new int[n+1];
        
        for (int i=0; i<n+1; i++) { p[i] = i; }
        
        for(int i=0; i<m; i++) {
            line = br.readLine();
            StringTokenizer st1 = new StringTokenizer(line);
            int op = Integer.parseInt(st1.nextToken());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            
            if (op == 0) { //합집합 연산
                union(a, b, p);
            } 
            else { //같은 집합 확인하기
                int ap = find(a, p);
                int bp = find(b, p);
                if (ap == bp) {
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            } 
        }
        
        br.close();
    }
    
    static void union(int a, int b, int[] p) {
        int ap = find(a, p);
        int bp = find(b, p);
        if (ap != bp) {
            p[ap] = bp;
        }
    }
    
    static int find(int a, int[] p) {
        // find root 
        int r = p[a];
        while(r != p[r]) r = p[r];
        
        // pass compression
        int c = a;
        while(c != p[c]) {
            int cp = p[c];
            p[c] = r;
            c = cp;
        }
        return r;
    }
}