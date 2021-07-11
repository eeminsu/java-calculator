/*
 * 출력 클래스
 * Panel(Operation)
 * 
 * -que : ArrayList<String> 입력값을 받을 큐
 * 
 * +add(String) : void - 큐에 입력값 input, 큐 출력
 * +result() : void - postFix Stack을 계산하여 결과값을 반환하는 클래스의 cal 메소드에 값을 위임하여 결과 값을 받음, 큐 비움, add()
 * +clear() : void - 큐 비움, 큐 출력
 * -render() : void - 큐 출력
 */

package calculator;

import java.util.ArrayList;

public class Panel {
	
	private ArrayList<String> que = new ArrayList<String>();
	private TransferQue operation;

	public Panel(TransferQue operation) {
		this.operation = operation;
	}
	
	public void add(String str) {
		que.add(str);
		render();
	}
	
	public void result() {
		//String result = operation.cal(que);
		que.clear();
		//add(result);
	}
	
	public void clear() {
		que.clear();
		render();
	}
	
	private void render() {
		System.out.println(String.join("", que));
	}

}
