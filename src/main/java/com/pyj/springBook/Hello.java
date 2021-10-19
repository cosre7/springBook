package com.pyj.springBook;

/*
 * Printer라는 인터페이스에만 의존하고 실제로 런타임 시 어떤 구체적인 클래스의 오브젝트를 사용하게 될지는 관심없다.
 * */
public class Hello {

	String name;
	Printer printer;
	
	/*
	 * 프로퍼티로 DI 받은 이름을 이용해 간단한 인사문구 만들기
	 * */
	public String sayHello() {
		return "Hello " + name;
	}
	
	/*
	 * - DI에 의해 의존 오브젝트로 제공받은 Printer 타입의 오브젝트에게 출력 작업을 위임
	 * - 구체적으로 어떤 방식으로 출력하는지는 상관없음
	 * - 어떤 방식으로 출력하도록 변경되어도 Hello 코드는 수정할 필요가 없다.
	 * */
	public void print() {
		this.printer.print(sayHello());
	}
	
	/*
	 * 인사 문구에 쓰일 이름을 스트링 값으로 DI받기
	 * */
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * 출력을 위해 사용할 Printer 인터페이스를 구현한 오브젝트 DI 받기
	 * */
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
}
