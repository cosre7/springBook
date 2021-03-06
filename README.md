### IoC 컨테이너를 이용해 애플리케이션 만들기
1. POJO 클래스
	- POJO 클래스 : 애플리케이션의 핵심 기능을 담고 있는 클래스
	- 유연한 변경 가능성을 고려해서 만든다.
	- 각자 기능에 충실하게 독립적으로 설계된 POJO 클래스를 만들고, 결합도가 낮은 유연한 관계를 가질 수 있도록 인터페이스를 이용해 연결해주는 것 까지가 IoC 컨테이너가 사용할 POJO를 준비하는 첫 단계
	
2. 설정 메타정보
	- 두 번째 필요한 것은 앞에서 만든 POJO 클래스 중 애플리케이션에 사용할 것을 선정하고 이를 IoC 컨테이너가 제어할 수 있도록 적절한 메타정보를 만들어 제공하는 작업
	- IoC 컨테이너의 가장 기초적인 역할은 오브젝트를 생성하고 이를 관리하는 것
	- 스프링 컨테이너가 관리하는 오브젝트 = 빈(bean)
	- IoC 컨테이너가 필요로 하는 설정 메타정보는 빈을 어떻게 만들고 어떻게 동작하게 할 것인가에 관한 정보
	- 스프링의 설정 메타정보는 BeanDefinition 인터페이스로 표현되는 순수한 추상 정보
		- 특정한 파일 포맷이나 형식에 재한되거나 종속되지 않는다.
		- XML, 소스코드 애노테이션, 자바 코드, 프로퍼티 파일 등.
		- BeanDefinition으로 정의되는 스프링 설정 메타 정보의 내용을 표현한 것이면 무엇이든 사용 가능
		- 원본의 포맷, 구조, 자료의 특성에 맞게 읽어와 BeanDefinition 오브젝트로 변환해주는 BeanDefinitionReader(인터페이스)가 있으면 된다.
	- IoC 컨테이너가 사용하는 빈 메타정보
		- 빈 아이디, 이름, 별칭 : 빈 오브젝트를 구분할 수 있는 식별자
		- 클래스 or 클래스 이름 : 빈으로 만들 POJO 클래스 또는 서비스 클래스 정보
		- 스코프 : 싱글톤, 프로토타입과 같은 빈의 생성 방식과 존재 범위
		- 프로퍼티 값 or 참조 : DI에 사용할 프로퍼티 이름과 값 또는 참조하는 빈의 이름
		- 생성자 파라미터 값 or 참조 : DI에 사용할 생성자 파라미터 이름과 값 또는 참조할 빈의 이름
		- 지연된 로딩 여부, 우선 빈 여부, 자동와이어링 여부, 부모 빈 정보, 빈팩토리 이름 등
	- 스프링 IoC 컨테이너
		1. 설정 메타정보를 읽어들인다.
		2. 빈 오브젝트를 생성한다.
		3. 프로퍼티나 생성자를 통해 의존 오브젝트를 주입하는 DI 작업을 수행한다.
		-> 이 작업을 통해 만들어지고, DI로 연결되는 오브젝트들이 모여서 하나의 애플리케이션을 구성하고 동작하게 된다.
	- 스프링 애플리케이션 = POJO 클래스와 설정 메타정보를 이용해 IoC 컨테이너가 만들어주는 오브젝트의 조합
	
	- StaticApplicationContext는 코드에 의해 설정 메타정보를 등록하는 기능을 제공하는 애플리케이션 컨텍스트. -> 테스트용으로 적합
	- IoC 컨테이너가 관리하는 빈은 클래스 단위가 아니라 오브젝트 단위이다.
	- IoC 컨테이너는 일단 빈 오브젝트가 생성되고 관계가 만들어지면 그 뒤로는 거의 관여하지 않는다.

### 1.1.2 IoC 컨테이너의 종류와 사용 방법
- XmlBeanDefinitionReader를 GenericApplicationContext가 이용하도록 해서 hello 빈과 printer 빈을 등록하고 사용하게 하기
	