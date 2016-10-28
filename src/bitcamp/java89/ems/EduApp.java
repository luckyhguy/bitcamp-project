package bitcamp.java89.ems;
import java.util.Scanner;
public class EduApp {
  public static void main(String[] args) {
    System.out.println("project-H 관리시스템에 오신걸 환영합니다.");


    //1) 사용자로부터 값을 입력받을 때 사용할 입력 도구 준비
    Scanner keyScan = new Scanner(System.in);


    ClassRoom classroom = new ClassRoom();

    System.out.print("이름(예:java89)?");
    classroom.name = keyScan.nextLine();


    System.out.print("종류(예:일반)?");
    classroom.type = keyScan.nextLine();

    System.out.print("크기(예:30)?");
    classroom.size = Integer.parseInt(keyScan.nextLine());

    System.out.print("전자칠판(y/n)?");
    classroom.electronicslate = (keyScan.nextLine().equals("y"))? true : false;

    System.out.print("칠판(y/n)?");
    classroom.blackboard = (keyScan.nextLine().equals("y")) ? true : false;

    System.out.print("소방기구(y/n)?");
    classroom.firefightingequipment = (keyScan.nextLine().equals("y")) ? true : false;

    System.out.print("사용중(y/n)?");
    classroom.working = (keyScan.nextLine().equals("y")) ? true : false;

    System.out.printf("이름: %s\n", classroom.name);
    System.out.printf("종류: %s\n", classroom.type);
    System.out.printf("크기: %d\n", classroom.size);
    System.out.printf("전자칠판: %b\n", classroom.electronicslate);
    System.out.printf("칠판: %b\n", classroom.blackboard);
    System.out.printf("소방기구: %b\n", classroom.firefightingequipment);
    System.out.printf("사용중: %b\n", classroom.working);


  }

}
