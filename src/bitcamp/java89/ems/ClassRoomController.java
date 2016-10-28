package bitcamp.java89.ems;

import java.util.Scanner;

public class ClassRoomController {
  static ClassRoom[] classrooms = new ClassRoom[100];
  static int length = 0;
  static Scanner keyScan;

  static void doAdd() {

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
  }


    static void doList() {
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

    static void doView() {
      String name = keyScan.nextLine();
      for (int i = 0; i < length; i++ ) {
        ClassRoom classroom = classrooms[i];
        if(name.equals(classrooms[i].name))
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
  }
