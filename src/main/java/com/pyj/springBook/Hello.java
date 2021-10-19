package com.pyj.springBook;

/*
 * Printer��� �������̽����� �����ϰ� ������ ��Ÿ�� �� � ��ü���� Ŭ������ ������Ʈ�� ����ϰ� ������ ���ɾ���.
 * */
public class Hello {

	String name;
	Printer printer;
	
	/*
	 * ������Ƽ�� DI ���� �̸��� �̿��� ������ �λ繮�� �����
	 * */
	public String sayHello() {
		return "Hello " + name;
	}
	
	/*
	 * - DI�� ���� ���� ������Ʈ�� �������� Printer Ÿ���� ������Ʈ���� ��� �۾��� ����
	 * - ��ü������ � ������� ����ϴ����� �������
	 * - � ������� ����ϵ��� ����Ǿ Hello �ڵ�� ������ �ʿ䰡 ����.
	 * */
	public void print() {
		this.printer.print(sayHello());
	}
	
	/*
	 * �λ� ������ ���� �̸��� ��Ʈ�� ������ DI�ޱ�
	 * */
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * ����� ���� ����� Printer �������̽��� ������ ������Ʈ DI �ޱ�
	 * */
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
}
