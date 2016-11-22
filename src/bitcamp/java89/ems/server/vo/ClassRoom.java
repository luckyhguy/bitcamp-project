package bitcamp.java89.ems.server.vo;

import java.io.Serializable;

public class ClassRoom implements Serializable {
  private static final long serialVersionUID = 1L;
  // 인스턴스 변수
  protected String name; // 이름
  protected String type; // 종류
  protected int size; // 크기
  protected boolean electronicslate; // 전자칠판
  protected boolean blackboard; // 칠판
  protected boolean firefightingequipment; // 소방 기구
  protected boolean working; //사용중

  public ClassRoom() {}

  public ClassRoom(String name, String type, int size, boolean electronicslate, boolean blackboard, boolean firefightingequipment, boolean working){
    this.name = name;
    this.type = type;
    this.size = size;
    this.electronicslate = electronicslate;
    this.blackboard = blackboard;
    this.firefightingequipment = firefightingequipment;
    this.working = working;
  }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isElectronicslate() {
		return electronicslate;
	}

	public void setElectronicslate(boolean electronicslate) {
		this.electronicslate = electronicslate;
	}

	public boolean isBlackboard() {
		return blackboard;
	}

	public void setBlackboard(boolean blackboard) {
		this.blackboard = blackboard;
	}

	public boolean isFirefightingequipment() {
		return firefightingequipment;
	}

	public void setFirefightingequipment(boolean firefightingequipment) {
		this.firefightingequipment = firefightingequipment;
	}

	public boolean isWorking() {
		return working;
	}

	public void setWorking(boolean working) {
		this.working = working;
	}

	@Override
	public String toString() {
		return "ClassRoom [name=" + name + ", type=" + type + ", size=" + size + ", electronicslate=" + electronicslate
				+ ", blackboard=" + blackboard + ", firefightingequipment=" + firefightingequipment + ", working=" + working
				+ "]";
	}
  
	
}





/*

*/
