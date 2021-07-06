/*
 * 피연산자 및 연사자 입력 클래스
 * 
 * 1자리씩 입력하는 방식은 뭔가 어색한 듯 함..
 * 피연산자를 통째로 입력받게 하는 방식을 생각해봐야 할듯..
 */

package calculator;

public class InputKey extends Keypad {

	public InputKey(Panel panel, String valStr) {
		super(panel, valStr);
	}

	@Override
	public void click() {
		panel.add(valStr);
	}

}
