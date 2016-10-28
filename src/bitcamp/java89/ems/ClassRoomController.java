package bitcamp.java89.ems;

import java.util.Scanner;

public class ClassRoomController {
  // 아래 인스턴스 변수들은 외부에서 사용할 일이 없기 때문에
  // private으로 접근을 제한한다.
  private ClassRoom[] classrooms = new ClassRoom[100];
  private int length = 0;
  private Scanner keyScan;

public ClassRoomController(Scanner keyScan) {
  this.keyScan = keyScan;
}

public void service() {
  loop:
  while (true) {

  System.out.print("교실관리>");

    switch (keyScan.nextLine()) {

    case "add" : this.doAdd(); break;

    case "list" : this.doList(); break;

    case "view" : this.doView(); break;

    case "delete" : this.doDelete(); break;

    case "update" : this.doUpdate(); break;

    case "main" :
      break loop;

    default :
      System.out.println("잘못입력하셨습니다.하산하세요!");

    }
  }
}


  private void doAdd() {

      while (length < this.classrooms.length) {
        ClassRoom classroom = new ClassRoom();


      System.out.print("이름(예:java89)?");
      classroom.name = this.keyScan.nextLine();
      System.out.print("종류(예:일반)?");
      classroom.type = this.keyScan.nextLine();
      System.out.print("크기(예:30)?");
      classroom.size = Integer.parseInt(this.keyScan.nextLine());
      System.out.print("전자칠판(y/n)?");
      classroom.electronicslate = (this.keyScan.nextLine().equals("y"))? true : false;
      System.out.print("칠판(y/n)?");
      classroom.blackboard = (this.keyScan.nextLine().equals("y")) ? true : false;
      System.out.print("소방기구(y/n)?");
      classroom.firefightingequipment = (this.keyScan.nextLine().equals("y")) ? true : false;
      System.out.print("사용중(y/n)?");
      classroom.working = (this.keyScan.nextLine().equals("y")) ? true : false;

      classrooms[length++] = classroom;

      System.out.print("계속 입력하시겠습니까(y/n)?");
      if (!this.keyScan.nextLine().equals("y"))
      break;
      }
  }
//아래 doXXX() 메서드들은 오직 service()에서만

  private void doList() {
      for (int i = 0; i < this.length; i++ ) {
      ClassRoom classroom = this.classrooms[i];
        System.out.printf("이름: %s,%s,%d,%b,%b,%b,%b\n",
        classroom.name,
        classroom.type,
        classroom.size,
        ((classroom.electronicslate)?"yes":"no"),
        ((classroom.blackboard)?"yes":"no"),
        ((classroom.firefightingequipment)?"yes":"no"),
        ((classroom.working)?"yes":"no")
        );

      }
    }

    private void doView() {
      String name = this.keyScan.nextLine();
      for (int i = 0; i < this.length; i++ ) {
        ClassRoom classroom = this.classrooms[i];
        if(name.equals(this.classrooms[i].name))
        System.out.printf("\n이름: \n%s,\n%s,\n%d,\n%b,\n%b,\n%b,\n%b\n",
        classroom.name,
        classroom.type,
        classroom.size,
        ((classroom.electronicslate) ? "yes":"no"),
        ((classroom.blackboard) ? "yes":"no"),
        ((classroom.firefightingequipment)?"yes":"no"),
        ((classroom.working)?"yes":"no")
        );

      }
    }


    private void doDelete() {
      System.out.print("삭제할 학생의 아이디는?");
      String name = this.keyScan.nextLine();
      for (int i = 0; i < this.length; i++ ) {

      for (int x = i + 1; x < length; x++, i++) {
        this.classrooms[i] = classrooms[x];
      }
        this.classrooms[--length] = null;

        System.out.printf("%s 학생 정보를 삭제하였습니다.\n", name);
         return; // 함수 실행 종료.
       }

     System.out.printf("%s 학생이 없습니다.", name);
   }


   private void doUpdate() {
     while (length < this.classrooms.length) {
       System.out.print("변경할 학생의 아이디는?");
       String name = this.keyScan.nextLine();

       for (int i = 0; i < this.length; i++ ) {
       if(name.equals(this.classrooms[i].name)) {

         ClassRoom classroom = this.classrooms[i];

         classroom.name = this.keyScan.nextLine();
         System.out.print("종류(예:일반)?");
         classroom.type = this.keyScan.nextLine();
         System.out.print("크기(예:30)?");
         classroom.size = Integer.parseInt(this.keyScan.nextLine());
         System.out.print("전자칠판(y/n)?");
         classroom.electronicslate = (this.keyScan.nextLine().equals("y"))? true : false;
         System.out.print("칠판(y/n)?");
         classroom.blackboard = (this.keyScan.nextLine().equals("y")) ? true : false;
         System.out.print("소방기구(y/n)?");
         classroom.firefightingequipment = (this.keyScan.nextLine().equals("y")) ? true : false;
         System.out.print("사용중(y/n)?");
         classroom.working = (this.keyScan.nextLine().equals("y")) ? true : false;

         System.out.print("저장하시겠습니까(y/n)?");
         if (!this.keyScan.nextLine().equals("y")) {
           System.out.print("저장하였습니다.");

         } else {
           System.out.printf("변경을 취소하였습니다.");
         }
         return;
       }
     }
     System.out.printf("%s 이라는 학생이 없습니다.", name);
   }
 }
}
