/* 작엽내용: 직렬화 적용
*/

package bitcamp.java89.ems.server.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import bitcamp.java89.ems.server.vo.ClassRoom;


public class ClassRoomController {
	private Scanner in;
	private PrintStream out;
	
  private String filename = "classroom-v1.6.data"; 
  private ArrayList<ClassRoom> list;
  private boolean changed;
  

  public ClassRoomController(Scanner in, PrintStream out)  {
    list = new ArrayList<ClassRoom>();
    this.in = in;
    this.out = out;
    
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

  public boolean service() {
    while (true) {
      out.println("교실관리>");
      out.println();
      String[] commands = in.nextLine().split("\\?");

      
      try {
      switch (commands[0]) {
      case "add" : this.doAdd(commands[1]); break;
      case "list" : this.doList(); break;
      case "view" : this.doView(commands[1]); break;
      case "delete" : this.doDelete(commands[1]); break;
      case "update" : this.doUpdate(commands[1]); break;
      case "main" : return true;
      case "quit" : return false;
      default :
        out.println("지원하지 않는 명령어입니다.");
      }
    } catch (IndexOutOfBoundsException e) {
      out.println("인덱스가 유효하지 않습니다.");
    } catch (Exception e) {
      out.println("실행 중 오류가 발생했습니다.");
      e.printStackTrace();
      } // try
    } // while
  }
  
  private void doList() {
      for (ClassRoom classroom : list) {
        out.printf("이름: %s,%s,%d,%b,%b,%b,%b\n",
          classroom.getName(),
          classroom.getType(),
          classroom.getSize(),
          ((classroom.isElectronicslate())?"yes":"no"),
          ((classroom.isBlackboard())?"yes":"no"),
          ((classroom.isFirefightingequipment())?"yes":"no"),
          ((classroom.isWorking())?"yes":"no"));
    }
  } 
//update?userId=aaa&password=1111&name=홍길동2&tel=1111-2222&email=hong2@test.com&working=n&birthYear=2000&school=비트대학
  private void doUpdate(String params) {
    String[] values = params.split("&");
    HashMap<String,String> paramMap = new HashMap<>();
    
    
		for (String value : values) {
			String[] kv = value.split("=");
			paramMap.put(kv[0], kv[1]);
		}
		
		for (ClassRoom classroom : list) {
		if (classroom.getName().equals(paramMap.get("name")))	{
			continue;
		}
    classroom.setType (paramMap.get("type"));
    classroom.setSize(Integer.parseInt(paramMap.get("size")));
    classroom.setElectronicslate(paramMap.get("electronicslate").equals("y") ? true : false);
    classroom.setBlackboard(paramMap.get("blackboard").equals("y") ? true : false);
    classroom.setFirefightingequipment(paramMap.get("firefightingequipmnet").equals("y") ? true : false);
    classroom.setWorking (paramMap.get("working").equals("y") ? true : false);

    changed = true;
    out.println("교실 정보를 변경하였습니다.");
    return;
		}
   out.println("해당 아이디의 학생이 없습니다.");
  }
  //add?name=이석환&type=1&size=33&electronicslate=y&blackboard=y&firefightingequipment=y&working=n
  private void doAdd(String params) {
  	 String[] values = params.split("&");
	    HashMap<String,String> paramMap = new HashMap<>();
	    
	    for (String value : values) {
	      String[] kv = value.split("=");
	      paramMap.put(kv[0], kv[1]);
	    }
	    
      ClassRoom classroom = new ClassRoom();
      classroom.setName (paramMap.get("name"));
      classroom.setType (paramMap.get("type"));
      classroom.setSize (Integer.parseInt(paramMap.get("size")));
      classroom.setElectronicslate (paramMap.get("electronicslate").equals("y") ? true : false);
      classroom.setBlackboard (paramMap.get("blackboard").equals("y") ? true : false);
      classroom.setFirefightingequipment (paramMap.get("firefightingequipment").equals("y") ? true : false);
      classroom.setWorking (paramMap.get("working").equals("y") ? true : false);

      if (existName(classroom.getName())) {
      	out.println("같은 이름의 교실이 존재합니다. 등록을 취소합니다.");
      	return;
      }
      
      list.add(classroom);
      changed = true;
      out.println("등록하였습니다.");
  }
  

  
  private boolean existName(String name) {
		for (ClassRoom classroom : list) {
			if (classroom.getName().toLowerCase().equals(name.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	private void doView(String params) {
 	 String[] kv = params.split("=");
 	 
 	 for (ClassRoom classroom : list) {
 		 if (!classroom.getName().equals(kv[1])) {
 			 continue;
 		 }
    out.printf("\n이름: \n%s,\n%s,\n%d,\n%b,\n%b,\n%b,\n%b\n",
    classroom.getName(),
    classroom.getType(),
    classroom.getSize(),
    ((classroom.isElectronicslate()) ? "yes":"no"),
    ((classroom.isBlackboard()) ? "yes":"no"),
    ((classroom.isFirefightingequipment())?"yes":"no"),
    ((classroom.isWorking()) ? "yes":"no"));
    return;
  }
 	 out.println("해당 이름의 교실이 없습니다.");
  }

  private void doDelete(String params) {
    String[] kv = params.split("=");
    
    for (ClassRoom classroom : list) {
	   if (!classroom.getName().equals(kv[1])) {
	  	 continue;
	   }
	   list.remove(classroom);
	   out.printf("%s 교실 정보를 삭제하였습니다.\n", classroom.getName());
	   changed = true;
	   return;
	   }
    out.println("해당 이름의 교실이 없습니다.");
  }
}
