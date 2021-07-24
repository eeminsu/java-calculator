/*
 * PostFix 변환 클래스
 * -postFixList : ArrayList<String> - postFix 변환이 완료된 리스트
 * -postFixStack : Stack<String> - postFix 변환을 위한 연산자 스택
 * 
 * -ToPriority() : int - 입력된 연산자를 우선순위로 변환하여 반환하는 메소드
 * +TransPostFix() : Stack<String> - que를 postFix Stack으로 변환하는 메소드
 * 
 * 21.07.10
 * TransPostFix() 메소드 구현중 stack peek 비교 관련해서 문제가 발생.. 원인파악해야함..
 * ToPriority() 메소드 추가 - stack peek 문제 해결 못해서 임시방편으로 추가..
 * 
 * 추후 개선사항
 * peek() == 비교연산 안되는 이유 파악
 * ToPriority 메소드 대신 다른 방법 생각해보기 (ex. enum..)
 * 
 * 21.07.24
 * String 클래스를 == 연산자로 비교할 시에는 비교 대상의 주소값을 비교한다.
 * equals는 값자체를 비교하기 때문에 == 연산자를 사용했을 때 false만 나오는 것
 * 
 * ToPriority 메소드 삭제
 * equlas 사용
 * 
 */

package calculator;

import java.util.ArrayList;
import java.util.Stack;

public class ConvertPostFix {
	
	ArrayList<String> postFixList = new ArrayList<>();
	Stack<String> postFixStack = new Stack<>();
	
	public ConvertPostFix(){}

	public ArrayList<String> TransPostFix(ArrayList<String> que){
		for(String token : que) {
			switch(token) {
			case "(":
			case "*":
			case "/":
				postFixStack.push(token);
				break;
			case ")":
				while(!postFixStack.isEmpty() && !postFixStack.peek().equals("(")) {
					postFixList.add(postFixStack.pop());
				}
				if(!postFixStack.isEmpty() && postFixStack.peek().equals("("))
					postFixStack.pop();
				break;
			case "+":
			case "-":
				while(!postFixStack.isEmpty() && (postFixStack.peek().equals("*") || postFixStack.peek().equals("/"))) {
					postFixList.add(postFixStack.pop());
				}
				postFixStack.push(token);
				break;
			default :
				postFixList.add(token);
				break;
			}
		}
		while(!postFixStack.isEmpty()) {
			postFixList.add(postFixStack.pop());
		}
		return postFixList;
	}
}
