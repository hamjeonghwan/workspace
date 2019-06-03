package kr.or.ddit.basic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TcpFileClient {
	// 클라이언트는 서버에 접속하여
	// 서버가 보내주는 파일을 D드라이브의 C_Lib폴더에 저장한다
	private Socket socket;
	private InputStream in;
	private FileOutputStream fout;

	public void clinetStart() {
		File file = new File("d:/C_Lib/Tulips.jpg");

		try {
			socket = new Socket("localhost", 7777);
			System.out.println("파일다운로드시작");

			fout = new FileOutputStream(file);
			in = socket.getInputStream();

			byte[] tmp = new byte[1024];
			int length = 0;
			while ((length = in.read(tmp)) != -1) {
				fout.write(tmp, 0, length);
			}
			fout.flush();
			System.out.println("다운로드완료");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				try {
					fout.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				try {
					socket.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		new TcpFileClient().clinetStart();
	}
}
