import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Baekjoon1302 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String key = br.readLine();
			
			if(map.containsKey(key)) {
				map.put(key, map.get(key) + 1);
				continue;
			}
			
			map.put(key, 1);
		}
		
		ArrayList<String> keyList = new ArrayList<String>(map.keySet());
		ArrayList<Integer> valList = new ArrayList<Integer>(map.values());
		ArrayList<Data> list = new ArrayList<Data>();
		for (int i = 0; i < keyList.size(); i++) {
			list.add(new Data(keyList.get(i), valList.get(i)));
		}
		
		Collections.sort(list);
		System.out.println(list.get(0).key);
	}
}

class Data implements Comparable<Data> {
	public String key;
	public int value;
	
	public Data() {
	}
	
	public Data(String key, int value) {
		super();
		this.key = key;
		this.value = value;
	}

	@Override
	public int compareTo(Data o) {
		if(o.value == this.value) {
			return this.key.compareTo(o.key);
		}
		
		return o.value - this.value;
	}
}