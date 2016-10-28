package bitcamp.java89.ems;


public class ClassRoom {
  // 인스턴스 변수
  String name; // 이름
  String type; // 종류
  int size; // 크기
  boolean electronicslate; // 전자칠판
  boolean blackboard; // 칠판
  boolean firefightingequipment; // 소방 기구
  boolean working; //사용중

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
}





/*
# System.in
- 시스템 기본 입력 장치 (키보드)의 정보를 갖고 있는 변수
*/
