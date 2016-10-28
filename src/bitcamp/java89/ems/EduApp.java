package bitcamp.java89.ems;
  import java.util.Scanner;



  public class EduApp {
    static Scanner keyScan = new Scanner(System.in);

    public static void main(String[] args) {

    ClassRoomController classroomController = new ClassRoomController(keyScan);

    System.out.println("project-H 관리시스템에 오신걸 환영합니다.");




    loop:
    while (true) {

    System.out.print("명령");
      switch (keyScan.nextLine()) {

      case "add" : classroomController.doAdd(); break;

      case "list" : classroomController.doList(); break;

      case "view" : classroomController.doView(); break;

      case "delete" : classroomController.doDelete(); break;

      case "update" : classroomController.doUpdate(); break;

      case "quit" : System.out.println("good-bye!"); break loop;

      default : System.out.println("잘못입력하셨습니다.하산하세요!");
      }
    }
  }
}
