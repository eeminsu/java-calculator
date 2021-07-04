/*
 * 피연산자 및 연사자 입력 클래스
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
