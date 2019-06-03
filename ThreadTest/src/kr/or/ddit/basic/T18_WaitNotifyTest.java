package kr.or.ddit.basic;
/**
 * wait()와 notify()를 이용한 두 쓰레드가 번갈아 가면서 실행하는 예제
 * @author pc11
 *
 */
public class T18_WaitNotifyTest {
/*
 * wait()메서드 => 동기화 영역에서 락을 풀고 Wait-Set영역으로 이동시킨다.
 * 
 * notify() 또는 notifyAll()메서드 => Wait-Set영역에 있는 쓰레드를 깨워서 실행될 수 있도록 한다.
 * 								    (notify()는 하나, notifyAll()은 Wait-Set에 있는 전부를 깨운다.)
 * 	=> wait()와 notify(), notifyAll()메서드는 동기화 영역에서만 실행할 수 있고, Object객체에서
 * 		제공되는 메서드이다.
 */
	public static void main(String[] args) {
		WorkObject workObj = new WorkObject();
		
		ThreadA thA = new ThreadA(workObj);
		ThreadB thB = new ThreadB(workObj);
		
		thA.start();
		thB.start();	
	}
}

//공통을 사용할 객체
class WorkObject{
	public synchronized void methodA() {
		System.out.println("methodA()메서드에서 작업 중...");
		
		notify();
		
		try {
			wait();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void methodB() {
		System.out.println("methodB()메서드에서 작업 중...");
		
		notify();
		
		try {
			wait();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

//WorkObject의 mehtodA()메서드만 호출하는 쓰레드
class ThreadA extends Thread{
	private WorkObject workObj;
	
	public ThreadA(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			workObj.methodA();
		}
	}
}

//WorkObject의 mehtodB()메서드만 호출하는 쓰레드
class ThreadB extends Thread{
	private WorkObject workObj;
	
	public ThreadB(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			workObj.methodB();
		}
	}
}