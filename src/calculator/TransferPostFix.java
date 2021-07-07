/*
 * PostFix 변환 클래스
 * -postFixList : ArrayList<String> - postFix 변환이 완료된 리스트
 * -postFixStack : Stack<String> - postFix 변환을 위한 연산자 스택
 * -outStack : Stack<String> - postFix 계산을 위한 스택
 * 
 * +transPostFix() : Stack<String> - que를 postFix Stack으로 변환하는 메소드
 * 
 * 21.07.07
 * que를 postFixList에 추가하는 메소드를 만들어야함..
 * 
 */

package calculator;

import java.util.ArrayList;
import java.util.Stack;

public class TransferPostFix {
	
	ArrayList<String> postFixList = new ArrayList<>();
	Stack<String> postFixStack = new Stack<>();
	
	public TransferPostFix(){}
	
	public Stack<String> transPostFix(ArrayList<String> que){
		for(String str : que) {
			if(str != "+" && str != "-" && str != "/" && str != "*") {
				postFixList.add(str);
			}
		}
		return null;
	}
}
