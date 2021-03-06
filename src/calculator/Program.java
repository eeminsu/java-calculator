/*
 * 사칙연산 계산기 메인 클래스
 * 
 * 오직 정수(Int)만 계산이 가능함
 * 0~9, *, /, +, -, (, )을 제외한 값을 입력할 경우 프로그램은 종료
 */

package calculator;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Program {
	
	private Panel panel = new Panel(new Operation(new TransferQue(), new ConvertPostFix()));
	private static Map<String, Keypad> key = new HashMap<>();
	
	public static void main(String[] args) {
		new Program().On(System.in);
	}
	
	public Program() {
		String oper = "0123456789+/*-()";
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
			if(!key.containsKey(val)) {
				System.out.println("잘못된 값을 입력하여 프로그램이 종료됩니다.");
				break Exit;
			}
			key.get(val).click();
		}
	}

}
