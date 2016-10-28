package bitcamp.java89.ems;

import java.util.Scanner;

public class ClassRoomController {
  ClassRoom[] classrooms = new ClassRoom[100];
  int length = 0;
  Scanner keyScan;

public ClassRoomController(Scanner keyScan) {
  this.keyScan = keyScan;
}

  public void doAdd() {

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


  public void doList() {
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

    public void doView() {
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


    public void doDelete() {
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
 }
