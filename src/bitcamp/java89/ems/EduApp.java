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

      case "menu" : doMenu(); break;

      case "go 1" : classroomController.service(); break;

      case "quit" :
        System.out.println("Good bye!");

      break loop;

      default:
        System.out.println("잘못입력하셨습니다.하산하세요!");
      }
    }
  }
  static void doMenu() {
    System.out.println("[메뉴]");
    System.out.println("1. 학생관리");
    System.out.println("메뉴 번호?");
  }
}
