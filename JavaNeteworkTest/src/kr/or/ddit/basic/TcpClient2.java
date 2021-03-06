package kr.or.ddit.basic;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient2 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 7777);
		
		Sender sender = new Sender(socket);
		Receiver receiver = new Receiver(socket);
		
		sender.start();
		receiver.start();
		
	}
}
