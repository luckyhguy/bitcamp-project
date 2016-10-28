[v0.7]
구현할 기능:

=>  EduApp에 있던 교실관리 명령어 처리를
    교실관리 전문가인 ClassRoomController로 이전한다.

=>  EduApp은 대신 메뉴 선택 기능을 추가한다.

산출물:
=> Student.java
=> EduApp.java (변경)
=> StudentController.java (추가)

학습 목표:
=> 리팩토링(refactoring)을 통해 명령어 코드를 관련된 클래스에 분류시키기.
=> 객체지향 설계 방법론 중에서 "고응집(high cohesion)"을 이해한다.
  High Cohesion? 한 클래스에 한 가지 역할에 집중해야 한다.
=> 한 클래스가 여러 가지 일을 하면 클래스 코드가 커지고, 유지보수에 안좋다.
=> 메서드나 변수에 대해 접근을 제어하는 방법과 이유를 이해한다.
  => ClassRoomController의 doXxx() 메서드들을 private 으로 접근을 제한한다.
  => 이 
