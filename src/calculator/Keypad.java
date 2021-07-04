/*
 * 입력 추상 클래스
 * 
 * -Panel - 패널 객체
 * -String - 입력 값
 * 
 * +click():void - 서브 클래스들의 메소드
 */

package calculator;

public abstract class Keypad {
	protected Panel panel;
	protected String valStr;
	
	public Keypad(Panel panel, String valStr) {
		this.panel = panel;
		this.valStr = valStr;
	}
	
	abstract public void click();
}
