/* 작엽내용: 직렬화 적용
*/

package bitcamp.java89.ems;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class ClassRoomController {
  private String filename = "classroom2.data"; 
  private ArrayList<ClassRoom> list;
  private boolean changed;
  private Scanner keyScan;

  public ClassRoomController(Scanner keyScan)  {
    list = new ArrayList<ClassRoom>();
    this.keyScan = keyScan;
    
    this.load(); // 기존의 데이터 파일을 읽어서 ArrayList를 로드한다.
  }

  public boolean isChanged() {
    return changed;
  }

  
  @SuppressWarnings("unchecked")
	private void load() {
    FileInputStream in0 = null;
    ObjectInputStream in = null;
    
    try {
      in0 = new FileInputStream(this.filename);
      in = new ObjectInputStream(in0);
    
      list = (ArrayList<ClassRoom>)in.readObject();
      
    } catch (EOFException e) {
      //파일을 모두 읽었다.
    } catch (Exception e) {
      System.out.println("학생 데이터 로딩 중 오류 발생!");
    } finally {
      try {
        in.close();
        in0.close();
      } catch (Exception e) {
        //close 하다가 예외 발생하면 무시한다.
      }
    }
  }  
  
  public void save()throws Exception {
    FileOutputStream out0 = new FileOutputStream(this.filename);
    ObjectOutputStream out = new ObjectOutputStream(out0);

    out.writeObject(list);
    changed = false;

    out.close();
    out0.close();
  }

  public void service() {
    loop:
    while (true) {
      System.out.print("교실관리>");
      String command = keyScan.nextLine().toLowerCase();

      try {
      switch (command) {
      case "add" : this.doAdd(); break;
      case "list" : this.doList(); break;
      case "view" : this.doView(); break;
      case "delete" : this.doDelete(); break;
      case "update" : this.doUpdate(); break;
      case "main" :
        break loop;
      default :
        System.out.println("지원하지 않는 명령어입니다.");
      }
    } catch (IndexOutOfBoundsException e) {
      System.out.println("인덱스가 유효하지 않습니다.");
    } catch (Exception e) {
      System.out.println("실행 중 오류가 발생했습니다.");
      } // try
    } // while
  }
  
  private void doList() {
      for (ClassRoom classroom : list) {
        System.out.printf("이름: %s,%s,%d,%b,%b,%b,%b\n",
          classroom.name,
          classroom.type,
          classroom.size,
          ((classroom.electronicslate)?"yes":"no"),
          ((classroom.blackboard)?"yes":"no"),
          ((classroom.firefightingequipment)?"yes":"no"),
          ((classroom.working)?"yes":"no"));
    }
  } 

  private void doUpdate() {
    System.out.print("변경할 강의실의 인덱스? ");
    int index = Integer.parseInt(this.keyScan.nextLine());
    
    ClassRoom oldClassRoom = list.get(index);

    // 새 학생 정보를 입력 받는다.
    ClassRoom classroom = new ClassRoom();
    System.out.printf("종류(예:일반)?", oldClassRoom.name);
    classroom.type = this.keyScan.nextLine();
    
    while (true) {
      try {
        System.out.printf("크기(예:30)?", oldClassRoom.type);
        classroom.size = Integer.parseInt(this.keyScan.nextLine());
        break;
      } catch (Exception e) {
        System.out.println("정수 값을 입력하세요.");
      }
    }
    
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
      classroom.name = oldClassRoom.name;
      list.set(index, classroom);
      changed = true;
      System.out.println("저장하였습니다.");
    } else {
      System.out.println("변경을 취소하였습니다.");
    }
  }

  private void doAdd() {
    while (true) {
      ClassRoom classroom = new ClassRoom();
      System.out.print("이름(예:java89)?");
      classroom.name = this.keyScan.nextLine();

      System.out.print("종류(예:일반)?");
      classroom.type = this.keyScan.nextLine();
  
      while (true) {
        try {
          System.out.print("크기(예:30)?");
          classroom.size = Integer.parseInt(this.keyScan.nextLine());
          break;
        } catch (Exception e) {
          System.out.println("정수값을 입력해주세요!");
        }
      }
      
      System.out.print("전자칠판(y/n)?");
      classroom.electronicslate = (this.keyScan.nextLine().equals("y"))? true : false;
  
      System.out.print("칠판(y/n)?");
      classroom.blackboard = (this.keyScan.nextLine().equals("y")) ? true : false;
  
      System.out.print("소방기구(y/n)?");
      classroom.firefightingequipment = (this.keyScan.nextLine().equals("y")) ? true : false;
  
      System.out.print("사용중(y/n)?");
      classroom.working = (this.keyScan.nextLine().equals("y")) ? true : false;

      list.add(classroom);
      changed = true;

      System.out.print("계속 입력하시겠습니까(y/n)?");
      if (!this.keyScan.nextLine().equals("y"))
       break;
    } // while
  }

  
  private void doView() {
    System.out.print("강의실의 인덱스? ");
    int index = Integer.parseInt(this.keyScan.nextLine());

    ClassRoom classroom = list.get(index);

    System.out.printf("\n이름: \n%s,\n%s,\n%d,\n%b,\n%b,\n%b,\n%b\n",
    classroom.name,
    classroom.type,
    classroom.size,
    ((classroom.electronicslate) ? "yes":"no"),
    ((classroom.blackboard) ? "yes":"no"),
    ((classroom.firefightingequipment)?"yes":"no"),
    ((classroom.working)?"yes":"no"));
  }

  private void doDelete() {
    System.out.print("삭제할 강의실의 인덱스?");
    int index = Integer.parseInt(keyScan.nextLine());
    ClassRoom deletedClassRoom = list.remove(index);
    changed = true;
    System.out.printf("%s 학생 정보를 삭제하였습니다.\n", deletedClassRoom.name);
    }
  }
