package bitcamp.java89.ems;
  
  import java.util.Scanner;

  public class EduApp {
    static Scanner keyScan = new Scanner(System.in);

    public static void main(String[] args) {
      ClassRoomController classroomController = new ClassRoomController(keyScan);

    System.out.println("project-H 관리시스템에 오신걸 환영합니다.");




    loop:
    while (true) {
      System.out.print("명령> ");
      String command  = keyScan.nextLine().toLowerCase();

      switch (command) {
      case "menu" : doMenu(); break;
      case "go 1" : classroomController.service(); break;
  //  case "go 2" : bookController.service(); break;
  //  case "go 3" : lecture.service(); break;
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
    System.out.println("1.교실 관리");
    System.out.println("메뉴 이동은 'go 메뉴번호'를 입력하세요.");
  }
}




