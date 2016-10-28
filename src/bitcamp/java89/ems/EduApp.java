package bitcamp.java89.ems;
  import java.util.Scanner;
    public class EduApp {
      public static void main(String[] args) {
        System.out.println("project-H 관리시스템에 오신걸 환영합니다.");


    // 여러명의 학생 정보를 입력하기 위한 레퍼런스 배열을 만든다.
    ClassRoom[] classrooms = new ClassRoom[100];
    int length = 0;   // 레퍼런스 배열에 몇명의 학생 정보를 저장했는지 갯수를 보관한다.
                      // 레퍼런스 배열에 몇 개의 Student 인스턴스가 들어 있는지 그 갯수를 보관한다.

    Scanner keyScan = new Scanner(System.in);

    // 반복 해서 입력 받는다.

    while (length < classrooms.length) {
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

    classrooms[length++] = classroom;


    System.out.print("계속 입력하시겠습니까(y/n)?");
    if (!keyScan.nextLine().equals("y"))
    break;
    }

    printclassroomList(classrooms, length);


}

  static void printclassroomList(ClassRoom[] classrooms, int length) {

    for (int i = 0; i < length; i++ ) {
    ClassRoom classroom = classrooms[i];
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
  }
