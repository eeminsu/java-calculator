/*
 * 'c' 입력 클래스
 */

package calculator;

public class ClearKey extends Keypad{

	public ClearKey(Panel panel, String valStr) {
		super(panel, valStr);
	}

	@Override
	public void click() {
		panel.clear();
	}

}
