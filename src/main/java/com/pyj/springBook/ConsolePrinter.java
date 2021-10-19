package com.pyj.springBook;

/*
 * Printer 인터페이스를 구현한 클래스는 얼마든지 생성 가능 - 2
 * - 단순하게 메시지를 받아서 표준 출력 스트림으로 출력하는 클래스
 * */
public class ConsolePrinter implements Printer {
	
	@Override
	public void print(String message) {
		System.out.println(message);
	}

}
