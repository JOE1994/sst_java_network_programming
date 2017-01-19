package first;

// Thread 클래스를 직접 상속하는 방식으로 스레드 구현.
// 이 방식은 상속을 이용했기 때문에, 우리 class(MyThread 클래스)의 사용이 상당히 제약을 받아요!!(다른 클래스를 상속받지 못함)
public class MyThread extends Thread {
	@Override
	public void run() {
		// 이 안에 새로운 실행흐름에 대한 코드를 작성!
		// super.run();
		for(int i=0;i<10;i++){
			System.out.println("현재의 i값은 : "+i);
			try {
				Thread.sleep(1000); // millisecond단위!
			} catch (InterruptedException e) {	
				e.printStackTrace();
			} 
		}
	}
	// 독립적인 실행흐름을 만들기 위해 특수한 메소드를 오버라이딩 해요!
	
	// sleep 함수를 호출하면, thread가 running상태에서 cPU자원을 사용하던 도중
	// 잠시 cPU 자원을 놓아주면서 running 상태에서 벗어난다. 
	// 그 사이 또 thread scheduler는 또 다른 runnable 상태의 스레드 하나를 
	// 골라서 실행시킨다. 
	
}
