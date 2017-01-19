package synchronization_thread;

public class Main {

	public static void main(String[] args) {
		// Thread를 3개 정도 생성할거에요!
		// 이렇게 생성된 Thread들을 실행시킬꺼에요!!
		System.out.println("main() 시작");
		
		// 공유객체를 하나 만들어보아요~
		//singleton??이 뭐지 찾아보자.
		SharedObject obj = new SharedObject();
		
		MyThread my1 = new MyThread(obj);
		MyThread my2 = new MyThread(obj);
		MyThread my3 = new MyThread(obj);
		
		Thread t1 = new Thread(my1);
		Thread t2 = new Thread(my2);
		Thread t3 = new Thread(my3,"IamThread3!");
		
		// JVM 안에 있는 스레드 스케줄러에게 실행 요청!
		t1.start();
		t2.start();
		t3.start();
		
	}
}
