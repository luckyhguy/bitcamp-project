package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.ClassRoomDao;
import bitcamp.java89.ems.server.vo.ClassRoom;

public class ClassRoomUpdateController implements Command {
  private ClassRoomDao classroomDao;

  public ClassRoomUpdateController() {
    classroomDao = ClassRoomDao.getInstance();
  }

  //update?userId=aaa&password=1111&name=홍길동2&tel=1111-2222&email=hong2@test.com&working=n&birthYear=2000&school=비트대학
  public void service(HashMap<String,String> paramMap, PrintStream out) {
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
}