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
