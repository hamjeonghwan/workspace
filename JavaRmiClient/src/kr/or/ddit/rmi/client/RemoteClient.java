package kr.or.ddit.rmi.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import kr.or.ddit.rmi.inf.RemoteInterface;
import kr.or.ddit.rmi.vo.FileInfoVO;
import kr.or.ddit.rmi.vo.TestVO;

/**
 * 클라이언트쪽의 프로젝트에도 서버의 패키지와 같은 구조로 Interface와 VO파일이 있어햐 한다
 * @author pc13
 *
 */
public class RemoteClient {
	public static void main(String[] args) throws Exception {
		// Registry 서버에 등록된 객체를 구한다.
		try {
			// 1. 등록된 서버를 찾기 위해 Registry객체를 생성한 후
			// 사용할 객체를 불러온다.
			Registry reg = LocateRegistry.getRegistry("192.168.203.2", 8888);
			RemoteInterface clientInf = (RemoteInterface) reg.lookup("server");
			
			// 이제부터는 불어온 객체의 메서드를 호출해서 사용할 수 있다.
			int a = clientInf.doRemotePrint("안녕하세오");
			System.out.println("반환값 => "+ a);
			System.out.println("=========================================");
			
			ArrayList<String> list = new ArrayList<>();
			list.add("대전");
			list.add("포항");
			list.add("연평도");
			list.add("백령도");
			list.add("모작도");
			clientInf.doPrintList(list);
			System.out.println("호출끝");
			System.out.println("=========================================");
			
			TestVO vo = new TestVO();
			vo.setTestId("전성희");
			vo.setTestNum(444);
			clientInf.doPrintVO(vo);
			System.out.println("VO 출력끝");
			System.out.println("=========================================");
			
			// 파일 전송하기
			File[] files = new File[2];
			files[0] = new File("d:/D_Other/KakaoTalk_20190502_153409595.jpg");
			files[1] = new File("d:/D_Other/Hydrangeas.jpg");
			
			FileInfoVO[] fInfo = new FileInfoVO[files.length];
			
			// 2개의 파일을 읽어서 byte[]에 담아서 서버측 메서드에 전달하면 된다.
			FileInputStream fin;
			for(int i = 0; i < files.length; i++) {
				int len = (int) files[i].length();
				fin = new  FileInputStream(files[i]);
				byte[] data = new byte[len];
				
				fin.read(data);
				
				fInfo[i] = new FileInfoVO();
				fInfo[i].setFileName(files[i].getName());
				fInfo[i].setFileData(data);
			}
			clientInf.setFiles(fInfo);
			
			System.out.println("파일전송끝");
			
			System.out.println("=========================================");
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
