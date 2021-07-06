/*
 * 연산 클래스
 * -postFixList : ArrayList<String> - postFix 변환이 완료된 리스트
 * -postFixStack : Stack<String> - postFix 변환을 위한 연산자 스택
 * -outStack : Stack<String> - postFix 계산을 위한 스택
 * 
 * +cal(que) : int - inFix 리스트를 입력받아 계산을 수행하는 메소드
 *
 *
 * 21.07.05
 * 2자리수 이상의 숫자 처리방식 고민..
 * 예를 들어 que에 1,2,3,+,2,3이 있을때 1,2,3을 합쳐서 123으로 2,3을 합쳐서 23으로 받는 것..
 * 
 * 21.07.06
 * ListtoString()추가 - ArrayList를 String으로 변환
 * stringRePlace()추가 - ListtoString()을 통해 변환된 String을 인자로 받아 피연산자와 연산자 구분
 * replaceList()추가 - stringRePlace()로 구분된 String을 인자로 받아 다시 ArrayList에 add
 * Operation 클래스를 3가지로 분리해야 할 것 같음
 * 1)que를 피연산자와 연사자로 구분시켜 다시 que에 저장하는 클래스
 * 2)que를 postFix Stack으로 변환하는 클래스
 * 3)postFix Stack을 계산하여 결과값을 반환하는 클래스
 */

package calculator;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Operation {
	private ArrayList<String> postFixList = new ArrayList<>();
	private Stack<String> postFixStack = new Stack<>();
	private Stack<String> outStack = new Stack<>();

	public String cal(ArrayList<String> que) {
		replaceList(stringRePlace(listtoString(que)));
		
		return null;
	}
	
	// ArrayList to String 수행
	private String listtoString(ArrayList<String> que) {
		return String.join("", que);
	}
	
	/*
	 * replaceAll 메소드를 이용하여 String 치환
	 * replcaeAll은 정규식을 사용할 수 있음, $1,$2... 그룹을 뜻함
	 * 
	 * 정규식을 ()로 묶어 그룹으로 만듬
	 * que에 쌓인 연산자와 피연산자를 나누어줄 수 있음 -> 2자리수 이상의 피연산자를 계산하기 위함
	 */
	private String stringRePlace(String str) {
		return str.replaceAll("([+\\/*\\-])", " $1 ");
	}
	
	/*
	 * 피연산자와 연산자가 분리된 String을 받아서 다시 ArrayList에 add함
	 */
	private ArrayList<String> replaceList(String str){
		ArrayList<String> replaceQue = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(str, " ");
		
		while(!st.hasMoreTokens()) {
			replaceQue.add(st.nextToken());
		}
		
		return replaceQue;
	}

}
