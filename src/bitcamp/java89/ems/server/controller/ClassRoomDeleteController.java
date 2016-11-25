package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.ClassRoomDao;

public class ClassRoomDeleteController implements Command {
  private ClassRoomDao classroomDao;

  public ClassRoomDeleteController() {
    classroomDao = ClassRoomDao.getInstance();
  }

  //delete?userId=aaa
  public void service(HashMap<String,String> paramMap, PrintStream out) {
    if (!classroomDao.existName(paramMap.get("name"))) {
      out.println("해당 이름의 교실이 없습니다.");
      return;
    }
    
    classroomDao.delete(paramMap.get("name"));
    out.printf("%s 교실 정보를 삭제하였습니다.\n", paramMap.get("name"));
  }
}
