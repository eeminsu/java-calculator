/*
 * 연산 클래스
 * 
 * -outStack : Stack<String> - postFix 계산을 위한 스택
 * 
 * +cal() : String - 계산을 위한 메소드
 * 
 * 21.07.11
 * cal() 메소드 기능 구현
 * 
 * 추후 개선 사항
 * 반복되는 구문 개선하기
 */

package calculator;

import java.util.ArrayList;
import java.util.Stack;

public class Operation {
	TransferQue tq = new TransferQue();
	ConvertPostFix cp = new ConvertPostFix();
	Stack<String> outStack = new Stack<>();
	
	public Operation(TransferQue tq, ConvertPostFix cp) {
		this.tq = tq;
		this.cp = cp;
	}
	
	public String cal(ArrayList<String> que) {
		for(String token : cp.TransPostFix(tq.transferQue(que))) {
			switch(token) {
			case "*":
				if(!outStack.isEmpty()) {
					int b = Integer.parseInt(outStack.pop());
					int a = Integer.parseInt(outStack.pop());
					int val = a * b;
					outStack.push(Integer.toString(val));
				}
				break;
			case "/":
				if(!outStack.isEmpty()) {
					int b = Integer.parseInt(outStack.pop());
					int a = Integer.parseInt(outStack.pop());
					int val = a / b;
					outStack.push(Integer.toString(val));
				}
				break;
			case "+":
				if(!outStack.isEmpty()) {
					int b = Integer.parseInt(outStack.pop());
					int a = Integer.parseInt(outStack.pop());
					int val = a + b;
					outStack.push(Integer.toString(val));
				}
				break;
			case "-":
				if(!outStack.isEmpty()) {
					int b = Integer.parseInt(outStack.pop());
					int a = Integer.parseInt(outStack.pop());
					int val = a - b;
					outStack.push(Integer.toString(val));
				}
				break;
			default:
				outStack.push(token);
				break;
			}
		}
		
		return outStack.pop();
	}

}
