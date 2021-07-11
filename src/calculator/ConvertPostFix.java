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
 */

package calculator;

import java.util.ArrayList;
import java.util.Stack;

public class ConvertPostFix {
	
	ArrayList<String> postFixList = new ArrayList<>();
	Stack<String> postFixStack = new Stack<>();
	
	public ConvertPostFix(){}
	
	private int ToPriority(String operator) {
		switch(operator) {
		case ")":
			return 0;
		case "*":
		case "/":
			return 1;
		case "+":
		case "-":
			return 2;
		case "(":
			return 3;
		default :
			return -1;
		}
	}
	
	public ArrayList<String> TransPostFix(ArrayList<String> que){
		for(String token : que) {
			switch(token) {
			case "(":
			case "*":
			case "/":
				postFixStack.push(token);
				break;
			case ")":
				while(!postFixStack.isEmpty() && ToPriority(postFixStack.peek()) != 3) {
					postFixList.add(postFixStack.pop());
				}
				if(!postFixStack.isEmpty() && ToPriority(postFixStack.peek()) == 3)
					postFixStack.pop();
				break;
			case "+":
			case "-":
				while(!postFixStack.isEmpty() && (ToPriority(postFixStack.peek()) < ToPriority(token))) {
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
