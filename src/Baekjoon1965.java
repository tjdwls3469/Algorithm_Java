import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1965 {
	public static int[] lis = new int[1000];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int box = 0;
		int index = 0;
		lis[0] = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i < cnt; i++) {
			box = Integer.parseInt(st.nextToken());
			if(box > lis[index]) {
				lis[++index] = box;
				continue;
			}
			lis[lowerBound(box, index)] = box;
		}
		
		System.out.println(index + 1);
	}	// end of main
	
	public static int lowerBound(int key, int index) {
		int low = 0;
		int high = index;
		int mid = 0;
		
		while(low < high) {
			mid = (low + high) / 2;
			if(lis[mid] >= key) {
				high = mid;
				continue;
			}
			low = mid + 1;
		}
		return low;
	}
}
