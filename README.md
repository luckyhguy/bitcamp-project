# v1.8
####구현할 기능 및 산출물:
- command 패턴 적용 
- Command.java 인터페이스 정의
  - 클라이언트 요청을 들어왔을 때 EduAppServer가 호출하는 메서드 규칙
  - 클라이언트 요청을 처리하는 클래스는 반드시 이 규칙을 따라야 한다. 
 

####학습목표:
- 커맨드 패턴 이해하며 또한 적용할 수 있다.


# v1.7
####구현할 기능 및 산출물:
- step1 
  - EduAppServer.java.01
    - static 멤버 대신 instance 멤버로 전환
- step2
  - EduAppServer.java.02
    - 클라이언트의 요청을 처리하는 부분을 스레드로 분리
  - RequestThread.java (생성)  
- step3
  - StudentDao.java 생성
    - StudentController.java 에서 데이터 처리 부분을 분리
    - Singleton 패턴 적용
    - insert(), update(), delete() 메서드에 동기화 적용
  - ContactDao.java 생성
    - ContactController.java 에서 데이터 처리 부분을 분리
    - Singleton 패턴 적용
    - insert(), update(), delete() 메서드에 동기화 적용
  - Controller들이 DAO를 공유하도록 변경 

####학습목표:
- 자바의 다양한 문법을 활용하여 유지보수가 좋은 구조로 코드를 변경할 수 있다.
- DAO(Data Access Object) 객체의 역할을 이해한다.
- Singleton 패턴을 이해하고 사용할 수 있다.


# v1.6
####구현할 기능:
- 클라이언트/서버 구조로 아키텍처를 변경 

####산출물:
- bitcamp/java89/ems/server 패키지 생성
  - EduApp.java를 이 패키지로 옮긴다.
    이름을 EduAppServer.java로 변경한다.
- bitcamp/java89/ems/server/vo 패키지 생성
  - Classroom.java, Contact.java, Curriculum.java, 
    Student.java, TextBook.java를 이 패키지로 옮긴다.
- bitcamp/java89/ems/server/controller 패키지 생성
  - ClassroomController.java, ContactController.java, 
    CurriculumController.java, StudentController.java, 
    TextBookController.java를 이 패키지로 옮긴다.
- bitcamp/java89/ems/client 패키지 생성
  - EduAppClient.java (생성)

####학습목표:
- 소켓 프로그래밍 훈련
- 역할 별로 클래스를 나누어 패키지로 관리하는 방법 훈련 

# v1.5
####구현할 기능:
- 연락처 관리 기능 

####산출물:
- Student.java
- StudentController.java
- EduApp.java (변경)
- Contact.java (추가)
- ContactConroller.java (추가)

####학습목표:
- 직렬화 프로그래밍 및 유지보수 연습

# v1.4
####구현할 기능:
- 직렬화 방식을 사용하여 데이터를 저장하고 읽는다.

####산출물:
- Student.java (변경)
- EduApp.java
- XxxController.java (변경)

####학습목표:
- 직렬화 기법을 이용하여 인스턴스의 값을 저장하고 읽을 수 있다.

# v1.3
####구현할 기능:
- 파일 저장 기능 추가
- 실행 예:
~~~~
명령> quit
학생 정보가 변경되었습니다. 그래도 종료하시겠습니까?(y/n) y
학생 정보가 변경된 것을 취소하고 종료합니다.
Good bye!
명령> quit
학생 정보가 변경되었습니다. 그래도 종료하시겠습니까?(y/n) n
명령> save
저장하였습니다.
명령> quit
Good bye!
~~~~
####산출물:
- Student.java
- EduApp.java (변경)
- XxxController.java (변경)

####학습목표:
- File I/O 클래스를 사용하여 데이터 저장과 로딩을 할 수 있다.

# v1.2
####구현할 기능:
- 우리가 만든 LinkedList 대신 자바에서 제공하는 ArrayList 사용하여 데이터 목록을 다룬다.

####산출물:
- Student.java
- EduApp.java
- XxxController.java (변경)
- LinkedList.java (제거)

####학습목표:
- 자바에서 제공하는 ArrayList를 사용할 수 있다. 


# v1.1
####구현할 기능:
- LinkedList에 예외처리 코드 추가
- StudentController에서 예외 다루기

####산출물:
- Student.java
- EduApp.java
- XxxController.java (변경)
- LinkedList.java (변경)

####학습목표:
- 메서드에서 예외를 던질 수 있다.
- 메서드를 호출할 때, 메서드가 던지는 예외를 다룰 수 있다.
- 예외를 활용해 오류가 발생하더라도 시스템을 멈추지 않고 실행할 수 있다. 

# v1.0
####구현할 기능:
- LinkedList에 제네릭을 적용한다.
- LinkedList를 사용하는 모든 코드에서 타입 캐스팅을 제거한다.

####산출물:
- Student.java
- EduApp.java
- XxxController.java (변경)
- LinkedList.java (변경)

####학습목표:
- 제네릭을 클래스에 적용하고 제네릭이 적용된 클래스를 사용할 수 있다.


# v0.9
####구현할 기능:
- LinkedList 클래스를 만든다.
- LinkedList를 StudentController에 적용한다.

####산출물:
- Student.java
- EduApp.java
- XxxController.java (변경)
- Box.java (삭제)
- LinkedList.java (추가)

####학습목표:
- LinkedList를 만들 수 있다.
- LinkedList를 사용하여 데이터를 저장,조회,변경,삭제할 수 있다.


# v0.8
####구현할 기능:
- Linked List 기법을 이용하여 학생, 강사 등의 데이터를 관리한다.
- 일단 StudentController만 적용한다.

####산출물:
- Student.java
- EduApp.java
- XxxController.java (변경)
- Box.java (추가)

####학습목표:
- Linked List의 사용법을 익힌다.
- Linked List를 구현하고 프로젝트에 적용할 수 있다.


# v0.7
####구현할 기능:
- EduApp에 있던 학생관리 명령어 처리를
   학생관리 전문가인 StudentController로 이전한다.
- EduApp은 대신 메뉴 선택 기능을 추가한다.

####산출물:
- Student.java
- EduApp.java (변경)
- StudentController.java (변경)

####학습목표:
- 리팩토링(refactoring)을 통해 명령어 코드를 관련된 클래스로 분류시키기.
- 객체지향 설계 방법론 중에서 "응집력 높이기(hign cohesion)"을 이해한다.
   High Cohesion? 한 클래스는 한 가지 역할에 집중해야 한다.
   - 한 클래스가 여러 가지 일을 하면 클래스 코드가 커지고, 유지보수에 안좋다.
- 메서드나 변수에 대해 접근을 제어하는 방법과 이유를 이해한다.
  - StudentController의 doXxx() 메서드들을 private 으로 접근을 제한한다.
  - 이 클래스의 내부 변수들도 private으로 접근을 제한한다.


# v0.6
####구현할 기능:
- 삭제 기능 추가
~~~~
명령> delete
삭제할 학생의 아이디는? hong
hong 학생 정보를 삭제하였습니다.
명령>
명령> delete
삭제할 학생의 아이디는? hong2
hong이라는 학생이 없습니다.
명령>

- 변경 기능 추가
명령> update
변경할 학생의 아이디는? hong
암호? 1111
이름? 임꺽정
전화? 111-1212
이메일? leem@test.com
재직중(y/n)? y
태어난해? 1980
최종학교? 1
저장하시겠습니까(y/n)? y
저장하였습니다.
명령>
...
저장하시겠습니까(y/n)? n
변경을 취소하였습니다.
명령>
명령> update
변경할 학생의 아이디는? hong
hong이라는 학생이 없습니다.
명령>
~~~~
####산출물:
- Student.java
- EduApp.java (변경)
- StudentController.java (변경)

####학습목표:
- 삭제와 변경을 추가하여 CRUD(Create/Read/Update/Delete) 기본 기능을 완성한다.
- 기존의 코드에 새 기능을 추가하는 경험을 해본다.
   이것이 유지보수 개발업무이다.

# v0.5
####구현할 기능:
- StudentController 클래스를 확장해서 사용할 수 있도록,
   학생 목록을 스태틱 변수로 저장하지 말고, 인스턴스 변수로 저장한다.
- 그에 따라 명령어를 처리하는 메서드도 인스턴스 메서드로 전환한다.

####산출물:
- Student.java
- EduApp.java (변경)
- StudentController.java (변경)

####학습목표:
- 인스턴스 변수와 인스턴스 메서드의 사용법을 익힌다.
- 생성자의 용도를 다시 한 번 확인한다.

# v0.4
####구현할 기능:
- 소스 코드 리팩토링(refactoring)
   - 유지보수하기 좋게 소스 코드를 좀 더 객체지향적으로 정리한다.
- EduApp에 있는 Student에 대해 명령을 다루는 데 관련된 메서드를
   따로 다른 클래스로 분류한다.

####산출물:
- Student.java
- EduApp.java
- StudentController.java (추가)

####학습목표:
- 클래스 문법의 용도를 다시 한 번 익힌다.
   - 클래스는 특정 작업과 관련된 메서드를 관리하기 좋게 분류할 때 사용한다.


# v0.3
####구현할 기능:
- 사용자에게 명령어를 입력 받는 프롬프트 기능을 추가한다.
예) 프로그램을 시작시키면 다음과 같이 동작한다.
```
명령> add
아이디(:hong)? 1
암호(예:1111)? 1
이름(예:홍길동)? 1
전화(예:010-1111-2222)? 1
이메일(예:hong@test.com)? 1
재직중(y/n)? y
태어난해(예:1980)? 1980
최종학교(예:비트고등학교)? 1
계속 입력하시겠습니까(y/n)? n
명령> list
1,1,1,1,1,yes,1980,1
명령> view
학생 아이디? hong
----------------------------
아이디: 1
암호: 1
이름: 1
전화: 1
이메일: 1
재직중: y
태어난해: 1980
최종학교: 1
명령>
```
####산출물:

####학습목표:
- 반복문 중첩해서 사용하는 방법을 익힌다.
- 입력 코드를 별도의 메서드로 분리하여 유지보수 하기 좋은 코드를 만드는 것을 익힌다.


# v0.2
####구현할 기능:
- 여러 명의 학생 정보를 입력 받아 저장하기

####산출물:
- Student.java
- EduApp.java (코드 변경)

####학습목표:
- 배열을 사용하여 여러 개의 인스턴스를 다루는 방법을 익힌다.
- 여러 번 입력 받기 위해 반복문을 사용하는 방법을 익힌다.
- 인스턴스와 레퍼런스의 관계를 이해한다.
- 배열 레퍼런스 변수와 배열 인스턴스 객체를 이해한다.
- 여러 명의 학생 정보를 출력하기 위해
   한 학생 정보를 출력하는 코드를 별도의 메서드로 분리한다.
   메서드의 용도와 사용법을 익힌다.

# v0.1
####구현할 기능:
- 학생 정보를 다룰 때 사용할 Student 데이터 타입을 정의한다.
- 학생 정보를 입력 받아 출력해본다.

####산출물:
- Student.java
- EduApp.java

####학습목표:
- Class 문법을 사용하여 사용자 정의 데이터 타입을 만드는 방법을 익힌다.
- 키보드를 통해 사용자로부터 입력 받는 방법을 배운다.
- 인스턴스를 생성하고 인스턴스에 값을 넣는 방법을 익힌다.
- 문자열 데이터를 int, boolean 등 다른 타입의 값으로 바꾸는 방법을 배운다.
