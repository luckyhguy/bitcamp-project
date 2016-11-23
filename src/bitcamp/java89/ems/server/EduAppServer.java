package bitcamp.java89.ems.server;

import java.net.ServerSocket;

public class EduAppServer {
  public static void main(String[] args) throws Exception {
    EduAppServer eduServer = new EduAppServer();
    eduServer.service();
  }
  
  private void service() throws Exception {
    ServerSocket ss = new ServerSocket(8888);
    System.out.println("서버 실행 중...");
    
    while (true) {
      new RequestThread(ss.accept()).start();
    }
    //ss.close();
  }
}
