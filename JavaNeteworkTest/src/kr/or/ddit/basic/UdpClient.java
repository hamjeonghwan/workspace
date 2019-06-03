package kr.or.ddit.basic;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {
	public void start() throws IOException {
		DatagramSocket datagramSocket = new DatagramSocket();
		InetAddress serverAddress = InetAddress.getByName("127.0.01");
		
		// 데이터가 저장될 공간으로 byte 배열을 생성한다
		
		byte[] msg = new byte[100];
		DatagramPacket outPacket = new DatagramPacket(msg, 1, serverAddress, 7777);
		DatagramPacket inPacket = new DatagramPacket(msg, msg.length);
		
		// 전송한다
		datagramSocket.send(outPacket);
		// 수신한다
		datagramSocket.receive(inPacket);
		
		System.out.println("현재 서버 시간 : " + new String(inPacket.getData()));
		datagramSocket.close();
	}
	public static void main(String[] args) throws IOException {
		new UdpClient().start();
	}
}
