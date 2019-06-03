package kr.or.ddit.basic;
/**
 *  이 클래스는 소켓을 통해서 메시지를 보내는 역할을 담당한다
 * @author pc13
 *
 */

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Sender  extends Thread{
	Socket socket;
	DataOutputStream dos;
	String name;
	public Sender(Socket socket) {
		this.socket = socket;
		name = "[" + socket.getInetAddress() + " : " + socket.getPort() + "]";
		
		try {
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		Scanner scan = new Scanner(System.in);
		while(dos != null) {
			try {
				dos.writeUTF(name + " >>> " + scan.nextLine());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		scan.close();
	}
}
