
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
0���� �����Ҷ�
i+1�� i�� ���ؼ� �ٸ��� +1

1�� �����Ҷ�
i+1�� i�� ���ؼ� �ٸ��� +1
���� ����� +1
*/

public class Solution1289 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int i=1;i<=tc;i++) {
			String memory = br.readLine();
			int ans = 0;
			for (int j = 0; j < memory.length() - 1; j++) {
				if(memory.charAt(j) != memory.charAt(j+1)) {
					ans++;
				}
			}
			if(memory.charAt(0) == '1') {
				ans++;
			}
			System.out.println("#" + i + " " + ans);
		}
	}
}
