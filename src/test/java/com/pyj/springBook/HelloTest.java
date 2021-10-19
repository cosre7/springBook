package com.pyj.springBook;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.StaticApplicationContext;

public class HelloTest {

	/*
	 * IoC �����̳� ����
	 * - ������ ���ÿ� �����̳ʷ� ����
	 * */ 
//	StaticApplicationContext ac = new StaticApplicationContext();
	// Hello Ŭ������ hello1�̶�� �̸��� �̱��� ������ �����̳ʿ� ����Ѵ�.
//	ac.registerSingleton("hello1", Hello.class); 
//	
	// IoC �����̳ʰ� ����� ���� �����ߴ��� Ȯ���ϱ� ���� ���� ��û�ϰ� Null�� �ƴ��� Ȯ��
//	Hello hello1 = ac.getBean("hello1", Hello.class);
//	assertThat(hello1, is(notNullValue()));
//	
	/*
	 * RootBeanDefinition�� ���� �⺻���� BeanDefinition �������̽��� ���� Ŭ����
	 * - �� ��Ÿ������ ���� ������Ʈ�� �����. �� Ŭ������ Hello�� �����Ѵ�.
	 * <bean class="springbook.learningtest...Hello" />�� �ش�
	 * */
//	BeanDefinition helloDef = new RootBeanDefinition(Hello.class);
	// ���� name ������Ƽ�� �� ���� �����Ѵ�.
	// <property name="name" value="Spring" />�� �ش�
//	helloDef.getPropertyValues().addPropertyValue("name", "String");
	// �տ��� ������ �� ��Ÿ������ hello2��� �̸��� ���� ������ ���
	// <bean id="hello2" ... />�� �ش�
//	ac.registerBeanDefinition("hello2", helloDef);
//	
	/*
	 * BeanDefinition���� ��ϵ� ���� �����̳ʿ� ���� ��������� ������Ƽ ������ �ƴ��� Ȯ��
	 * */
//	Hello hello2 = ac.getBean("hello2", Hello.class);
//	assertThat(hello2.sayHello(), is("Hello Spring"));
//	
	// ó�� ����� ��� �� ��° ����� ���� ������ Hello Ŭ���� ������ ������ ������Ʈ�� ����
	// -> ���� ������Ʈ ������ ��ϵǰ� ��������� ������ ���� Ŭ���� Ÿ���̴��� �� ���� ����ϸ�
	//    ���� �ٸ� �� ������Ʈ�� �����ȴ�.
//	assertThat(hello1, is(not(hello2)));
//	
//	assertThat(ac.getBeanFactory().getBeanDefinitionCount(), is(2));
	
	@Test
	public void registerBeanWithDependency() {
		StaticApplicationContext ac = new StaticApplicationContext();
		
		// StringPrinter Ŭ���� Ÿ���̸� printer ��� �̸��� ���� ���� ���
		ac.registerBeanDefinition("printer", 
				new RootBeanDefinition(StringPrinter.class));
		
		BeanDefinition helloDef = new RootBeanDefinition(Hello.class);
		// �ܼ����� ���� ������Ƽ ���
		helloDef.getPropertyValues().addPropertyValue("name", "Spring");
		// ���̵� printer�� �� ���� ���۷����� ������Ƽ�� ���
		helloDef.getPropertyValues().addPropertyValue("printer", 
				new RuntimeBeanReference("printer"));
		
		ac.registerBeanDefinition("hello", helloDef);
		
		Hello hello = ac.getBean("hello", Hello.class);
		hello.print();
		
		/*
		 * Hello Ŭ������ print() �޼ҵ�� DI�� Printer Ÿ���� ������Ʈ���� ��û�ؼ� �λ縻��
		 * ���
		 * -> ����� ��Ʈ������ �����صδ� printer ���� ���� Ȯ��.
		 * */
		assertThat(ac.getBean("printer").toString(), is("Hello Spring"));
	}
	
	@Test 
	public void genericApplicationContext() {
		GenericApplicationContext ac = new GenericApplicationContext();
		
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(ac);
		// XmlBeanDefinitionReader �� �⺻������ Ŭ�����н��� ���ǵ� ���ҽ��κ��� ������ �д´�.
		reader.loadBeanDefinitions(
				"springBook/src/main/webapp/WEB-INF/spring/genericApplicationContext.xml");
		ac.refresh(); // ��� ��Ÿ������ ����� �Ϸ�Ǿ����� ���ø����̼� �����̳ʸ� �ʱ�ȭ�϶�� ���
		
		Hello hello = ac.getBean("hello", Hello.class);
		hello.print();
		
		assertThat(ac.getBean("printer").toString(), is("Hello Spring"));
	}
}
