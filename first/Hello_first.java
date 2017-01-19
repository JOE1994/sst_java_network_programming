package first;

// 프로그램이 종료된다는 의미는 해당 프로그램(프로세스) 내에서 생성된 모든 스레드가 종료되면 프로그램이 종료된다고 표현합니다!!
public class Hello_first {

	public static void main(String[] args) {
		System.out.println("main start!!");
		// Thread객체를 하나 생성.
		MyThread t = new MyThread();
		
		MyThread_interface n = new MyThread_interface();
		Thread tt = new Thread(n); 	// 하나의 객체를 다른 객체에게 넣어주는 방식(Dependency Injection)
	    // t.run(); // 이렇게 스레드를 실행시키는 게 아니에요!
		t.start(); // Thread를 실행시키는 메소드.
		// start 메소드를 호출하면 요상한 현상이 발생??
		// 자바프로그램은 JVM이 모든 실행을 관장해요!!
		// JVM 안에 Thread Scheduler가 존재해요!!
		
		// 자바 프로그램을 실행시키면, JVM이 제일 먼저 Thread Scheduler로 하여금 Main 메소드를 호출하게 하면서 시작된다. 
		// 메인 메소드를 포함한 모든 스레드를 Thread Scheduler가 실행시키는 것이다!! 
		// 우리가 직접 스레드 실행을 제어할 수는 없고, Thread Scheduler로 하여금 스레드를 실행시키도록 요청해야 함.
		// "해당 thread를 시간될 떄 실행시켜주세요!!" 라고 요청하는 것.. 스레드가 정확히 시작되는 시점을 파악하기는 어려운 것이 단점... thread scheduler가 리소스가 있을 때 실행시켜주기 떄문임..
		// 중요포인트*** start 메소드는 non-blocking 메소드야!!!! blocking 메소드 아니야!!!
		
		tt.setDaemon(true); // default는 FALSE!. Daemon thread로 설정할지 말지 결정하는 메소드.
		tt.start();
		
		//다른 스레드(tt)가 종료될 때까지 메인 스레드가 기다리도록 하려면 어떻게 하나요???
		try {
			tt.join(); // tt가 종료된 후에 메인 스레드가 계속 진행함!!
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// tt.interrupt(); // 스케줄러한테, 적당한 시간에 스레드 tt를 종료시켜주세요 하고 요청.
		System.out.println("메인이 종료되요!!!"); 
		
		
		// main method가 끝나면 프로그램이 종료
	}
}

// 독립적인 실행흐름을 나타내는 스레드를 만들려고 해요!!
// 스레드 없이는 채팅 프로그램 못 만든다!! 다중 채팅 프로그램 구현에서 매우 큰 비중을 차지하는 스레드!!

