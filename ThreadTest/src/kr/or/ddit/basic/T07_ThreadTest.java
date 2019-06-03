package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/**
 * 컴퓨터와 가위바위보 하는 프로그램
 * @author pc14
 *
 */
public class T07_ThreadTest {
public static boolean inputCheck;

	/*
 * 컴퓨터와 가위바위보를 진행하는 프로그램을 작성하시오
 * 
 * 컴퓨터와 가위바위보는 난수를 이용하여 구하고
 * 사용자의 가위바위보는 showInputDialog()메서드를 이용하여 입력받는다.
 * 
 * 입력시간은 5초로 제한하고 카운트다운을 진행한다.
 * 5초안에 입력이 없으면 게임을 진 것으로 한다.
 * 
 * 5초안에 입력이 완료되면 승패를 출력한다.
 * 
 * 결과예시)
 * 
 *  == 결  과 ==
 * 컴퓨터 : 가위
 * 당  신 : 바위
 * 결  과 : 당신이 이겼습니다.
 */
	public static void main(String[] args) {
		Thread th1 = new UserInput();
		Thread th2 = new Count();
		
		th1.start();
		th2.start();
		
	int com = (int) (Math.random() * 3 + 1);
		
		
		
	}

}

class UserInput extends Thread{
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("가위바위보 중에 하나를 입력하세요.");
		
		//입력이 완료되면 inputCheck 변수를 true로 변경한다.
		T07_ThreadTest.inputCheck = true;
		
		System.out.println("입력한 값은" + str + "입니다.");
		
	}
	
		
}

class Count extends Thread{
	@Override
		public void run() {
			for(int i = 10; i >= 1; i--) {
				// 입력이 완료되었는지 여부를 검사하고 입력이 완료되면
				// run() 메서드를 종료시킨다. 즉 현재 쓰레드를 종료시킨다.
				if(T07_ThreadTest.inputCheck == true) {
					return; // run() 메서드가 종료되면 쓰레드도 끝난다.
				}
				
				System.out.println(i);
				
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
		}
			 //10초가 경과 되었는데도 입력이 없으면 프로그램을 종료한다.
		      System.out.println("10초가 지났습니다. 프로그램을 종료합니다.");
		      System.exit(0);   //프로그램을 종료시키는 명령
	}
}








