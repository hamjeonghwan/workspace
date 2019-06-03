package kr.or.ddit.basic;
/**
 *  이 클래스는소켓에서 메시지를 받아서화면에 출력하는 역할을 담당한다
 * @author pc13
 *
 */

import java.io.DataInputStream;
import java.net.Socket;

public class Receiver extends Thread{
	Socket socket;
	DataInputStream dis;
	
	public Receiver(Socket socket) {
			this.socket = socket;
			
			try {
				dis = new DataInputStream(socket.getInputStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	@Override
	public void run() {
		// dis가 제대로 생성된 경우
		while(dis != null) {
			try {
				System.out.println(dis.readUTF());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
