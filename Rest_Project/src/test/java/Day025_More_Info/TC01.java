package Day025_More_Info;

import java.util.HashMap;
import java.util.Map;

public class TC01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Map<String, Double> data = new HashMap<String, Double>();
		
		data.put("ABC", (double)  1234444);
		data.put("ABC1", (double) 1234555);
		
		System.out.println(data.get("ABC"));
		System.out.println(data.get("ABC1"));
	}

}
