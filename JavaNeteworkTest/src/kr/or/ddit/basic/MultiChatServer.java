package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MultiChatServer {
	Map<String, Socket> clients;
	
	public MultiChatServer() {
		clients = Collections.synchronizedMap(new HashMap<>());
	}
	
	public void serverStart() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다");
			
			while(true) {
				socket = serverSocket.accept();
				
				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "] 에서 접속하였습니다");
				// 메시지전송 처리를 하는 쓰레드 생성 및 실행
				
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	public void sendToAll(String msg) {
		Iterator<String> it = clients.keySet().iterator();
		while(it.hasNext()) {
			try {
				String name = it.next();
				
				DataOutputStream out =new DataOutputStream(clients.get(name).getOutputStream());
				out.writeUTF(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 서버에서 클라이언트로 메시지를 전송할 Thread를 inner클래스로 정의
	// inner 클래스에서는 부모클래스의 멤버들을 직접 사용할 수 있다
	class ServerReceiver extends Thread{
		Socket socket;
		DataInputStream din;
		DataOutputStream dout;
		
		  public ServerReceiver(Socket socket) {
			  try {
				
				  din = new DataInputStream(socket.getInputStream());
				  dout = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
	
		  @Override
		public void run() {
			  String name = "";
			  try {
				name = din.readUTF();
				
				sendToAll("#" + name + "님이 입장했습니다");
				
				clients.put(name, socket);
				
				System.out.println("현제 서버 접속자 수는 " + clients.size() + "명 입니다");
				
				// 이 후의 메시지 처리는 반복문으로 처리한다 
				// 한 클라이언트가 보낸 메시지를 다른 모든 클라이언트에게 보내준다
				
				while (din != null ){
					sendToAll( din.readUTF());
					
				}
			  }catch (IOException e) {
					e.printStackTrace();
			} finally {
				// 이 finally가 실행된다는 것은 클라이언트의 접속이 종료되었다는 의미이다
				sendToAll(name + "님이 나가셨습니다");
				
				clients.remove(name);
				
				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "] 에서 접속을 종료하였습니다");
				System.out.println("현재 접속자 수는 " + clients.size() + "명 입니다");
			}
		  }
}
	
	public static void main(String[] args) {
		new MultiChatServer().serverStart();
		
	}
}
