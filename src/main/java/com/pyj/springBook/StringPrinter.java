package com.pyj.springBook;

/*
 * Printer 인터페이스를 구현한 클래스는 얼마든지 생성 가능 - 1
 * - StringBuffer에 메시지를 넣는 방식으로 메시지를 출력하는 StringPrinter 클래스
 * */
public class StringPrinter implements Printer {
	
	private StringBuffer buffer = new StringBuffer();
	
	/*
	 * Printer 인터페이스의 메소드
	 * - 내장 버퍼에 메시지를 추가해준다.
	 * */
	@Override
	public void print(String message) {
		this.buffer.append(message);
	}
	
	/*
	 * 내장 버퍼에 추가해둔 메시지를 스트링으로 가져온다.
	 * */
	public String toString() {
		return this.buffer.toString();
	}

}
