package com.pyj.springBook;

/*
 * Printer �������̽��� ������ Ŭ������ �󸶵��� ���� ���� - 2
 * - �ܼ��ϰ� �޽����� �޾Ƽ� ǥ�� ��� ��Ʈ������ ����ϴ� Ŭ����
 * */
public class ConsolePrinter implements Printer {
	
	@Override
	public void print(String message) {
		System.out.println(message);
	}

}
