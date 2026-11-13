import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PrintWriter out = new PrintWriter(System.out);
 
    public static void readArr(int[] arr) throws IOException {
        int n = arr.length;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
 
    public static void sort(int[] arr) {
        int n = arr.length;
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            int randomPos = i + rnd.nextInt(n - i);
            arr[i] = arr[randomPos];
            arr[randomPos] = tmp;
        }
        Arrays.sort(arr);
    }

    public static void solve() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        // int t=1;
        while (t-->0) {
            solve();
        }
        out.close();
    }
};