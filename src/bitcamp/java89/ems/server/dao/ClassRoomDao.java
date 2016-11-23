package bitcamp.java89.ems.server.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import bitcamp.java89.ems.server.vo.ClassRoom;


public class ClassRoomDao {
	static ClassRoomDao obj;
	
	private String filename = "classroom-v1.7.data";
	private ArrayList<ClassRoom> list;
	private boolean changed;
  
 
	public static ClassRoomDao getInstance() {
	  if (obj == null) {
      obj = new ClassRoomDao();
    }
    
    return obj;
  }
  
  public ClassRoomDao() {
    this.load(); 
  }

  public ArrayList<ClassRoom> getList() {
    return this.list;
  }
  
  synchronized public ClassRoom getOne(String name) {
    for (ClassRoom classroom : list) {
      if (classroom.getName().equals(name)) {
        return classroom;
      }
    }
    return null;
  }
  
  public void insert(ClassRoom classroom) {
    list.add(classroom);
    changed = true;
  }
  
  synchronized public void update(ClassRoom classroom) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getName().equals(classroom.getName())) {
        list.set(i, classroom);
        changed = true;
        return;
      }
    }
  }
  
  synchronized public void delete(String name) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getName().equals(name)) {
        list.remove(i);
        changed = true;
        return;
      }
    }
  }
  
  public boolean existName(String name) {
    for (ClassRoom classroom : list) {
      if (classroom.getName().toLowerCase().equals(name)) {
        return true;
      }
    }
    return false;
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
      // 파일을 모두 읽었다.
    } catch (Exception e) {
      System.out.println("학생 데이터 로딩 중 오류 발생!");
      list = new ArrayList<>();
    } finally {
      try {
        in.close();
        in0.close();
      } catch (Exception e) {
        // close하다가 예외 발생하면 무시한다.
      }
    }
  }

  synchronized public void save() throws Exception {
    FileOutputStream out0 = new FileOutputStream(this.filename);
    ObjectOutputStream out = new ObjectOutputStream(out0);

    out.writeObject(list);
    
    changed = false;

    out.close();
    out0.close();
  }

}
		
		
		
		
		
		
		