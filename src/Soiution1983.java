import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Soiution1983 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= tc; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int cnt = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			double[] point = new double[cnt];
			
			double targetNum = 0.0;
			for (int j = 0; j < cnt; j++) {
				String str1 = br.readLine();
				StringTokenizer st1 = new StringTokenizer(str1);
				int num1 = Integer.parseInt(st1.nextToken());
				int num2 = Integer.parseInt(st1.nextToken());
				int num3 = Integer.parseInt(st1.nextToken());
				double total = num1*0.35 + num2*0.45 + num3*0.2;
				if(j == (target-1)) {
					targetNum = total;
				}
				point[j] = total;
			}
			
			int targetRank = 0;
			for (int j = 0; j < cnt; j++) {
				if(point[j] > targetNum) {
					targetRank++;
				}
			}
			
			String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
			System.out.println("#" + i + " " + grade[targetRank/(cnt/10)]);
			
		}	// end of tc
	}	// end of main
}
