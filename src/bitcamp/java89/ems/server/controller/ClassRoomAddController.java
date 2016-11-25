package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.ClassRoomDao;
import bitcamp.java89.ems.server.vo.ClassRoom;

public class ClassRoomAddController implements Command {
  private ClassRoomDao classroomDao;

  public ClassRoomAddController() {
    classroomDao = ClassRoomDao.getInstance();
  }

  
  public void service(HashMap<String,String> paramMap, PrintStream out) {
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
}
