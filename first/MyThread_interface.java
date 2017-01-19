package first;

// 인터페이스 이용한 스레드 구현.
public class MyThread_interface implements Runnable{

	@Override
	public void run() {
		// 이 안에 새로운 실행흐름에 대한 코드를 작성!
		// super.run();
		for(int i=0;i<10;i++){
			System.out.println("현재의 i값은 : "+i);
			try {
				Thread.sleep(1000); // millisecond단위!
				// 인터럽트 걸렸는지 확인.
				// 걸렸으면 run이 종료되도록 적당히 처리.
				// stop 메소드에 비해 안전한 종료가 가능함.
				
				if(Thread.currentThread().isInterrupted()){
					break;
				}
			} catch (InterruptedException e) {	
				e.printStackTrace();
			} 
		}
	}
}
