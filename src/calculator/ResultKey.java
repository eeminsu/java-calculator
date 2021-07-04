/*
 * '=' 입력 클래스
 */

package calculator;

public class ResultKey extends Keypad{

	public ResultKey(Panel panel, String valStr) {
		super(panel, valStr);
	}

	@Override
	public void click() {
		panel.result();
	}

}
