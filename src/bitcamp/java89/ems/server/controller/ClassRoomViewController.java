package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.ClassRoomDao;
import bitcamp.java89.ems.server.vo.ClassRoom;

public class ClassRoomViewController implements Command {
  private ClassRoomDao classroomDao;

  public ClassRoomViewController() {
    classroomDao = ClassRoomDao.getInstance();
  }

  //view?userId=aaa
  public void service(HashMap<String,String> paramMap, PrintStream out) {
    if (!classroomDao.existName(paramMap.get("name"))) {
      out.println("해당 아이디의 학생이 없습니다.");
      return;
    }
    
  	ClassRoom classroom = classroomDao.getOne(paramMap.get("name"));
		out.printf("\n이름: \n%s,\n%s,\n%d,\n%b,\n%b,\n%b,\n%b\n", classroom.getName(), classroom.getType(),
				classroom.getSize(), ((classroom.isElectronicslate()) ? "yes" : "no"),
				((classroom.isBlackboard()) ? "yes" : "no"), ((classroom.isFirefightingequipment()) ? "yes" : "no"),
				((classroom.isWorking()) ? "yes" : "no"));
  }
}
