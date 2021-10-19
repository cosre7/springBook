package com.pyj.springBook;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;

public class HelloTest {

	/*
	 * IoC 컨테이너 생성
	 * - 생성과 동시에 컨테이너로 동작
	 * */ 
//	StaticApplicationContext ac = new StaticApplicationContext();
	// Hello 클래스를 hello1이라는 이름의 싱글톤 빈으로 컨테이너에 등록한다.
//	ac.registerSingleton("hello1", Hello.class); 
//	
	// IoC 컨테이너가 등록한 빈을 생성했는지 확인하기 위해 빈을 요청하고 Null이 아닌지 확인
//	Hello hello1 = ac.getBean("hello1", Hello.class);
//	assertThat(hello1, is(notNullValue()));
//	
	/*
	 * RootBeanDefinition은 가장 기본적인 BeanDefinition 인터페이스의 구현 클래스
	 * - 빈 메타정보를 담은 오브젝트를 만든다. 빈 클래스는 Hello로 지정한다.
	 * <bean class="springbook.learningtest...Hello" />에 해당
	 * */
//	BeanDefinition helloDef = new RootBeanDefinition(Hello.class);
	// 빈의 name 프로퍼티에 들어갈 값을 지정한다.
	// <property name="name" value="Spring" />에 해당
//	helloDef.getPropertyValues().addPropertyValue("name", "String");
	// 앞에서 생성한 빈 메타정보를 hello2라는 이름을 가진 빈으로 등록
	// <bean id="hello2" ... />에 해당
//	ac.registerBeanDefinition("hello2", helloDef);
//	
	/*
	 * BeanDefinition으로 등록된 빈이 컨테이너에 의해 만들어지고 프로퍼티 설정이 됐는지 확인
	 * */
//	Hello hello2 = ac.getBean("hello2", Hello.class);
//	assertThat(hello2.sayHello(), is("Hello Spring"));
//	
	// 처음 등록한 빈과 두 번째 등록한 빈이 동일한 Hello 클래스 이지만 별개의 오브젝트로 생성
	// -> 빈은 오브젝트 단위로 등록되고 만들어지기 때문에 같은 클래스 타입이더라도 두 개를 등록하면
	//    서로 다른 빈 오브젝트가 생성된다.
//	assertThat(hello1, is(not(hello2)));
//	
//	assertThat(ac.getBeanFactory().getBeanDefinitionCount(), is(2));
	
	@Test
	public void registerBeanWithDependency() {
		StaticApplicationContext ac = new StaticApplicationContext();
		
		// StringPrinter 클래스 타입이며 printer 라는 이름을 가진 빈을 등록
		ac.registerBeanDefinition("printer", 
				new RootBeanDefinition(StringPrinter.class));
		
		BeanDefinition helloDef = new RootBeanDefinition(Hello.class);
		// 단순값을 갖는 프로퍼티 등록
		helloDef.getPropertyValues().addPropertyValue("name", "Spring");
		// 아이디가 printer인 빈에 대한 레퍼런스를 프로퍼티로 등록
		helloDef.getPropertyValues().addPropertyValue("printer", 
				new RuntimeBeanReference("printer"));
		
		ac.registerBeanDefinition("hello", helloDef);
		
		Hello hello = ac.getBean("hello", Hello.class);
		hello.print();
		
		/*
		 * Hello 클래스의 print() 메소드는 DI된 Printer 타입의 오브젝트에게 요청해서 인사말을
		 * 출력
		 * -> 결과를 스트링으로 저장해두는 printer 빈을 통해 확인.
		 * */
		assertThat(ac.getBean("printer").toString(), is("Hello Spring"));
	}
}
