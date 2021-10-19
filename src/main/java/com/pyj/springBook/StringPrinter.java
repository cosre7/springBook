package com.pyj.springBook;

/*
 * Printer �������̽��� ������ Ŭ������ �󸶵��� ���� ���� - 1
 * - StringBuffer�� �޽����� �ִ� ������� �޽����� ����ϴ� StringPrinter Ŭ����
 * */
public class StringPrinter implements Printer {
	
	private StringBuffer buffer = new StringBuffer();
	
	/*
	 * Printer �������̽��� �޼ҵ�
	 * - ���� ���ۿ� �޽����� �߰����ش�.
	 * */
	@Override
	public void print(String message) {
		this.buffer.append(message);
	}
	
	/*
	 * ���� ���ۿ� �߰��ص� �޽����� ��Ʈ������ �����´�.
	 * */
	public String toString() {
		return this.buffer.toString();
	}

}
