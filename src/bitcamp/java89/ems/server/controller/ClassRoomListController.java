package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.ClassRoomDao;
import bitcamp.java89.ems.server.vo.ClassRoom;

public class ClassRoomListController implements Command {
  private ClassRoomDao classroomDao;

  public ClassRoomListController() {
    classroomDao = ClassRoomDao.getInstance();
  }

  public void service(HashMap<String,String> paramMap, PrintStream out) {
  	ArrayList<ClassRoom> list = classroomDao.getList();
		for (ClassRoom classroom : list) {
			out.printf("%s,%s,%d,%b,%b,%b,%b\n", classroom.getName(), classroom.getType(), classroom.getSize(),
					((classroom.isElectronicslate()) ? "yes" : "no"), ((classroom.isBlackboard()) ? "yes" : "no"),
					((classroom.isFirefightingequipment()) ? "yes" : "no"), ((classroom.isWorking()) ? "yes" : "no"));
		}
	}
}
