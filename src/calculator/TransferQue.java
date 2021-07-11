/*
 * que 변환 클래스
 * +transferQue(que) : ArrayList<String> - 입력받은 que를 피연산자와 연사자로 구분시켜 다시 que에 저장
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
 * 
 * 21.07.07
 * Operation클래스는 que를 피연산자와 연산자로 구분시켜 다시 que에 저장하는 역할만 하게끔 변경
 * stringRePlace(), ListtoString()제거 - 단순 API를 리턴하는 메소드는 불필요하다고 봄
 * cal() 메소드 변경 - 클래스 기능의 변경에 따른 메소드 변경
 * replaceList() 제거 - 변경된 cal() 메소드와 기능이 겹쳐 제거
 */

package calculator;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class TransferQue {
	
	public TransferQue(){}

	public ArrayList<String> transferQue(ArrayList<String> que) {
		ArrayList<String> replaceQue = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(String.join("", que).replaceAll("([)\\(+\\/*\\-])", " $1 "), " ");
		
		while(st.hasMoreTokens()) {
			replaceQue.add(st.nextToken());
		}
		return replaceQue;
	}
	
}
