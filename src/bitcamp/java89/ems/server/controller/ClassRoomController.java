package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import bitcamp.java89.ems.server.dao.ClassRoomDao;
import bitcamp.java89.ems.server.vo.ClassRoom;

public class ClassRoomController {
	private Scanner in;
	private PrintStream out;

	private ClassRoomDao classroomDao;

	public ClassRoomController(Scanner in, PrintStream out) {
		
		this.in = in;
		this.out = out;

		classroomDao = ClassRoomDao.getInstance();
	}

	public void save() throws Exception {
		if (classroomDao.isChanged()) {
			classroomDao.save();
		}
	}

	public boolean service() {
		while (true) {
			out.println("교실관리> ");
			out.println();

			String[] commands = in.nextLine().split("\\?");

			try {
				switch (commands[0]) {
				case "add":
					this.doAdd(commands[1]);
					break;
				case "list":
					this.doList();
					break;
				case "view":
					this.doView(commands[1]);
					break;
				case "delete":
					this.doDelete(commands[1]);
					break;
				case "update":
					this.doUpdate(commands[1]);
					break;
				case "main":
					return true;
				case "quit":
					return false;
				default:
					out.println("지원하지 않는 명령어입니다.");
				}
			} catch (IndexOutOfBoundsException e) {
				out.println("인덱스가 유효하지 않습니다.");
			} catch (Exception e) {
				out.println("실행 중 오류가 발생했습니다.");
			} // try
		} // while
	}

	private void doList() {
		ArrayList<ClassRoom> list = classroomDao.getList();
		for (ClassRoom classroom : list) {
			out.printf("이름: %s,%s,%d,%b,%b,%b,%b\n", classroom.getName(), classroom.getType(), classroom.getSize(),
					((classroom.isElectronicslate()) ? "yes" : "no"), ((classroom.isBlackboard()) ? "yes" : "no"),
					((classroom.isFirefightingequipment()) ? "yes" : "no"), ((classroom.isWorking()) ? "yes" : "no"));
		}
	}

	// update?userId=aaa&password=1111&name=홍길동2&tel=1111-2222&email=hong2@test.com&working=n&birthYear=2000&school=비트대학
	private void doUpdate(String params) {
    String[] values = params.split("&");
    HashMap<String,String> paramMap = new HashMap<>();
    
    
		for (String value : values) {
			String[] kv = value.split("=");
			paramMap.put(kv[0], kv[1]);
		}
		
		
		if (!classroomDao.existName(paramMap.get("name"))) {
			out.println("해당 이름의 교실이 없습니다.");
			return;
		}

	ClassRoom classroom = new ClassRoom();
	classroom.setName(paramMap.get("name"));
	classroom.setType(paramMap.get("type"));
	classroom.setSize(Integer.parseInt(paramMap.get("size")));
	classroom.setElectronicslate(paramMap.get("electronicslate").equals("y")?true:false);
	classroom.setBlackboard(paramMap.get("blackboard").equals("y")?true:false);
	classroom.setFirefightingequipment(paramMap.get("firefightingequipmnet").equals("y")?true:false);
	classroom.setWorking(paramMap.get("working").equals("y")?true:false);

	classroomDao.update(classroom);
	out.println("교실 정보를 변경하였습니다.");
	}

	// add?name=이석환&type=1&size=33&electronicslate=y&blackboard=y&firefightingequipment=y&working=n
	private void doAdd(String params) {
		String[] values = params.split("&");
		HashMap<String, String> paramMap = new HashMap<>();

		for (String value : values) {
			String[] kv = value.split("=");
			paramMap.put(kv[0], kv[1]);
		}

		if (classroomDao.existName(paramMap.get("name"))) {
			out.println("이미 해당 이름의 교실이 있습니다. 등록을 취소하겠습니다.");
			return;
		}

		ClassRoom classroom = new ClassRoom();
		classroom.setName(paramMap.get("name"));
		classroom.setType(paramMap.get("type"));
		classroom.setSize(Integer.parseInt(paramMap.get("size")));
		classroom.setElectronicslate(paramMap.get("electronicslate").equals("y") ? true : false);
		classroom.setBlackboard(paramMap.get("blackboard").equals("y") ? true : false);
		classroom.setFirefightingequipment(paramMap.get("firefightingequipment").equals("y") ? true : false);
		classroom.setWorking(paramMap.get("working").equals("y") ? true : false);

		classroomDao.insert(classroom);
		out.println("등록하였습니다.");
	}

	// view?name=이석환
	private void doView(String params) {
		String[] kv = params.split("=");

		if (!classroomDao.existName(kv[1])) {
			out.println("해당 이름의 교실이 없습니다.");
			return;
		}

		ClassRoom classroom = classroomDao.getOne(kv[1]);
		out.printf("\n이름: \n%s,\n%s,\n%d,\n%b,\n%b,\n%b,\n%b\n", classroom.getName(), classroom.getType(),
				classroom.getSize(), ((classroom.isElectronicslate()) ? "yes" : "no"),
				((classroom.isBlackboard()) ? "yes" : "no"), ((classroom.isFirefightingequipment()) ? "yes" : "no"),
				((classroom.isWorking()) ? "yes" : "no"));
		return;
	}

	// delete?name=이석환
	private void doDelete(String params) {
    String[] kv = params.split("=");
    
	   if (!classroomDao.existName(kv[1])) {
	  	 out.println("해당 이름의 교실이 없습니다.");
	  			 return;
	   }
	   
	   classroomDao.delete(kv[1]);
	   out.printf("%s 교실 정보를 삭제하였습니다.\n", kv[1]);
  }
}