package calculator;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Program {
	
	private Panel panel = new Panel(new Operation());
	private static Map<String, Keypad> key = new HashMap<>();
	
	public static void main(String[] args) {
		new Program().On(System.in);
	}
	
	public Program() {
		String oper = "0123456789+/*-";
		String[] strArray = oper.split("");
		Stream<String> strStream = Arrays.stream(strArray);
		strStream.forEach(a -> key.put(a, new InputKey(panel, a)));
		key.put("=", new ResultKey(panel, "="));
		key.put("c", new ClearKey(panel, "c"));
	}
	
	public static void On(InputStream src) {
		Scanner sc = new Scanner(src);
		
		Exit :
		while(sc.hasNext()) {
			String val = sc.next();
			if(!key.containsKey(val)) break Exit;
			key.get(val).click();
		}
	}

}
