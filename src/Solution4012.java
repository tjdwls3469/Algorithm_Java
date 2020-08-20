import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution4012 {
    public static int[][] map = new int[17][17];
    public static boolean[] check = new boolean[17];
    public static int N;
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
         
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 1; tc <= testCase; tc++) {
            N = Integer.parseInt(br.readLine());
             
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 1; j <= N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }   // map 초기화 OK
             
            combination(0, 1);
            sb.append('#').append(tc).append(' ').append(ans).append('\n');
             
            ans = Integer.MAX_VALUE;
            Arrays.fill(check, 1, N + 1, false);
        }   // end of tc
        System.out.println(sb);
    }   // end of main
     
    public static int A;
    public static int B;
    public static int ans = Integer.MAX_VALUE;
    public static int diff;
     
    public static void combination(int cnt, int num) {
        if (cnt == N / 2) {
            A = B = 0;
            for (int i = 1; i < check.length; i++) {
                for (int j = 1; j < check.length; j++) {
                    if(i == j) {
                        continue;
                    }
                    if(check[i] && check[j]) {      // check가 true이면 스타트팀
                        A += map[i][j];
                        continue;
                    }
                    if(!check[i] && !check[j]) {    // check가 false이면 링크팀
                        B += map[i][j];
                    }
                }
            }
            diff = Math.abs(A-B);
            if(diff < ans) {
                ans = diff;
            }
            return;
        }
 
        if (cnt == 0) {     // 가지치기(이게 없으면 중복 발생) 예) 스타트(1,3,6) 링크(2,4,5) / 스타트(2,4,5) 링크(1,3,6) 중복발생
            check[1] = true;
            combination(cnt + 1, 2);
            return;
        }
        for (int i = num; i <= N; i++) {
            check[i] = true;
            combination(cnt + 1, i + 1);
            check[i] = false;
        }
    }
}